package net.diverginglensestudios.undeadremains.entity.custom.Skeletons;

import net.diverginglensestudios.undeadremains.entity.ai.ModMoveThroughVillageGoal;
import net.diverginglensestudios.undeadremains.entity.client.DrownedSkeleton.DrownedSkeletonModel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class DrownedSkeletonEntity extends Monster {

	boolean searchingForLand;

	protected final WaterBoundPathNavigation waterNavigation;
	protected final GroundPathNavigation groundNavigation;

	// Synced entity data
	private static final EntityDataAccessor<Boolean> ATTACKING =
			SynchedEntityData.defineId(DrownedSkeletonEntity.class, EntityDataSerializers.BOOLEAN);

	// Animation states
	public final AnimationState idleAnimationState = new AnimationState();
	private int idleAnimationTimeout = 0;

	public final AnimationState attackAnimationState = new AnimationState();
	public int attackAnimationTimeout = 0;

	public DrownedSkeletonEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
		this.setMaxUpStep(1.0F);
		this.moveControl = new DrownedSkeletonEntity.DrownedSkeletonMoveControl(this);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
		this.waterNavigation = new WaterBoundPathNavigation(this, pLevel);
		this.groundNavigation = new GroundPathNavigation(this, pLevel);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ATTACKING, false);
	}

	public void setAttacking(boolean attacking) {
		this.entityData.set(ATTACKING, attacking);
	}

	public boolean isAttacking() {
		return this.entityData.get(ATTACKING);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.FOLLOW_RANGE, 35.0D)
				.add(Attributes.MOVEMENT_SPEED, (double)0.23F)
				.add(Attributes.ATTACK_DAMAGE, 3.0D)
				.add(Attributes.ARMOR, 2.0D);
	}


	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new DrownedSkeletonEntity.DrownedSkeletonSupportGoal(this, 8.0D));
		this.goalSelector.addGoal(1, new DrownedSkeletonEntity.DrownedGoToWaterGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new DrownedSkeletonEntity.DrownedGoToBeachGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new DrownedSkeletonEntity.DrownedSwimUpGoal(this, 1.0D, this.level().getSeaLevel()));
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));

		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, DrownedSkeletonEntity.class)).setAlertOthers(ZombifiedPiglin.class));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::okTarget));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Axolotl.class, true, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
	}


	@Override
	public void tick() {
		super.tick();
		if(this.level().isClientSide()) {
			setupAnimationStates();
		}
	}

	private void setupAnimationStates() {
		if(this.idleAnimationTimeout <= 0) {
			this.idleAnimationTimeout = this.random.nextInt(40) + 80;
			this.idleAnimationState.start(this.tickCount);
		} else {
			--this.idleAnimationTimeout;
		}
	}

	@Override
	protected void updateWalkAnimation(float pPartialTick) {
		float f;
		if(this.getPose() == Pose.STANDING) {
			f = Math.min(pPartialTick * 6F, 1f);
		} else {
			f = 0f;
		}
		this.walkAnimation.update(f, 0.2f);
	}


	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	public boolean isPushedByFluid() {
		return !this.isSwimming();
	}

	boolean wantsToSwim() {
		if (this.searchingForLand) {
			return true;
		} else {
			LivingEntity livingentity = this.getTarget();
			return livingentity != null && livingentity.isInWater();
		}
	}

	public void travel(Vec3 pTravelVector) {
		if (this.isControlledByLocalInstance() && this.isInWater() && this.wantsToSwim()) {
			this.moveRelative(0.01F, pTravelVector);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
		} else {
			super.travel(pTravelVector);
		}
	}

	public void updateSwimming() {
		if (!this.level().isClientSide) {
			if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
				this.navigation = this.waterNavigation;
				this.setSwimming(true);
			} else {
				this.navigation = this.groundNavigation;
				this.setSwimming(false);
			}
		}
	}

	public boolean isVisuallySwimming() {
		return this.isSwimming();
	}

	protected boolean closeToNextPos() {
		Path path = this.getNavigation().getPath();
		if (path != null) {
			BlockPos blockpos = path.getTarget();
			if (blockpos != null) {
				double d0 = this.distanceToSqr((double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ());
				if (d0 < 4.0D) {
					return true;
				}
			}
		}
		return false;
	}

	public void setSearchingForLand(boolean pSearchingForLand) {
		this.searchingForLand = pSearchingForLand;
	}


	@Override
	public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
		return super.causeFallDamage(pFallDistance, pMultiplier*0.2f, pSource);
	}


	public boolean checkSpawnObstruction(LevelReader pLevel) {
		return pLevel.isUnobstructed(this);
	}

	public boolean okTarget(@Nullable LivingEntity p_32396_) {
		if (p_32396_ != null) {
			return !this.level().isDay() || p_32396_.isInWater();
		} else {
			return false;
		}
	}


	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.SALMON_AMBIENT;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource pDamageSource) {
		return SoundEvents.SKELETON_HURT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.SKELETON_DEATH;
	}


	//Support goal
	static class DrownedSkeletonSupportGoal extends Goal {
		private final DrownedSkeletonEntity mob;
		private final double radius;

		public DrownedSkeletonSupportGoal(DrownedSkeletonEntity mob, double radius) {
			this.mob = mob;
			this.radius = radius;
		}

		@Override
		public boolean canUse() {
			return true; // always active
		}

		@Override
		public boolean canContinueToUse() {
			return true;
		}

		@Override
		public void tick() {
			// Get nearby living entities
			List<LivingEntity> entities = this.mob.level().getEntitiesOfClass(
					LivingEntity.class,
					this.mob.getBoundingBox().inflate(radius),
					e -> e != this.mob && e.isAlive()
			);

			for (LivingEntity target : entities) {
				// Optional: only buff hostile mobs (same "team")
				if (target instanceof Monster) {

					// Apply Conduit Power
					target.addEffect(new MobEffectInstance(
							MobEffects.CONDUIT_POWER,
							40, // duration (2 seconds, constantly refreshed)
							1,
							true,
							false
					));

					// Apply Glowing
					target.addEffect(new MobEffectInstance(
							MobEffects.GLOWING,
							40,
							0,
							true,
							false
					));
					// Apply strength
					target.addEffect(new MobEffectInstance(
							MobEffects.DAMAGE_BOOST,
							40,
							0,
							true,
							false
					));
					// Apply damage resist
					target.addEffect(new MobEffectInstance(
							MobEffects.DAMAGE_RESISTANCE,
							40,
							0,
							true,
							false
					));
				}
			}
		}
	}

	//Swim Up Goal
	static class DrownedSwimUpGoal extends Goal {
		private final DrownedSkeletonEntity drowned;
		private final double speedModifier;
		private final int seaLevel;
		private boolean stuck;

		public DrownedSwimUpGoal(DrownedSkeletonEntity pDrowned, double pSpeedModifier, int pSeaLevel) {
			this.drowned = pDrowned;
			this.speedModifier = pSpeedModifier;
			this.seaLevel = pSeaLevel;
		}

		public boolean canUse() {
			return !this.drowned.level().isDay() && this.drowned.isInWater() && this.drowned.getY() < (double)(this.seaLevel - 2);
		}

		public boolean canContinueToUse() {
			return this.canUse() && !this.stuck;
		}

		public void tick() {
			if (this.drowned.getY() < (double)(this.seaLevel - 1) && (this.drowned.getNavigation().isDone() || this.drowned.closeToNextPos())) {
				Vec3 vec3 = DefaultRandomPos.getPosTowards(this.drowned, 4, 8, new Vec3(this.drowned.getX(), (double)(this.seaLevel - 1), this.drowned.getZ()), (double)((float)Math.PI / 2F));
				if (vec3 == null) {
					this.stuck = true;
					return;
				}
				this.drowned.getNavigation().moveTo(vec3.x, vec3.y, vec3.z, this.speedModifier);
			}
		}

		public void start() {
			this.drowned.setSearchingForLand(true);
			this.stuck = false;
		}

		public void stop() {
			this.drowned.setSearchingForLand(false);
		}
	}

	//Go To Beach Goal
	static class DrownedGoToBeachGoal extends MoveToBlockGoal {
		private final DrownedSkeletonEntity drowned;

		public DrownedGoToBeachGoal(DrownedSkeletonEntity pDrowned, double pSpeedModifier) {
			super(pDrowned, pSpeedModifier, 8, 2);
			this.drowned = pDrowned;
		}

		public boolean canUse() {
			return super.canUse() && !this.drowned.level().isDay() && this.drowned.isInWater() && this.drowned.getY() >= (double)(this.drowned.level().getSeaLevel() - 3);
		}

		protected boolean isValidTarget(LevelReader pLevel, BlockPos pPos) {
			BlockPos blockpos = pPos.above();
			return pLevel.isEmptyBlock(blockpos) && pLevel.isEmptyBlock(blockpos.above()) ? pLevel.getBlockState(pPos).entityCanStandOn(pLevel, pPos, this.drowned) : false;
		}

		public void start() {
			this.drowned.setSearchingForLand(false);
			this.drowned.navigation = this.drowned.groundNavigation;
			super.start();
		}

		public void stop() {
			super.stop();
		}
	}

	//Go To Water Goal
	static class DrownedGoToWaterGoal extends Goal {
		private final PathfinderMob mob;
		private double wantedX;
		private double wantedY;
		private double wantedZ;
		private final double speedModifier;
		private final Level level;

		public DrownedGoToWaterGoal(PathfinderMob pMob, double pSpeedModifier) {
			this.mob = pMob;
			this.speedModifier = pSpeedModifier;
			this.level = pMob.level();
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canUse() {
			if (!this.level.isDay()) {
				return false;
			} else if (this.mob.isInWater()) {
				return false;
			} else {
				Vec3 vec3 = this.getWaterPos();
				if (vec3 == null) {
					return false;
				} else {
					this.wantedX = vec3.x;
					this.wantedY = vec3.y;
					this.wantedZ = vec3.z;
					return true;
				}
			}
		}

		public boolean canContinueToUse() {
			return !this.mob.getNavigation().isDone();
		}

		public void start() {
			this.mob.getNavigation().moveTo(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
		}

		@Nullable
		private Vec3 getWaterPos() {
			RandomSource randomsource = this.mob.getRandom();
			BlockPos blockpos = this.mob.blockPosition();

			for(int i = 0; i < 10; ++i) {
				BlockPos blockpos1 = blockpos.offset(randomsource.nextInt(20) - 10, 2 - randomsource.nextInt(8), randomsource.nextInt(20) - 10);
				if (this.level.getBlockState(blockpos1).is(Blocks.WATER)) {
					return Vec3.atBottomCenterOf(blockpos1);
				}
			}
			return null;
		}
	}

	//Custom Move Control
	static class DrownedSkeletonMoveControl extends MoveControl {
		private final DrownedSkeletonEntity drowned;

		public DrownedSkeletonMoveControl(DrownedSkeletonEntity pDrowned) {
			super(pDrowned);
			this.drowned = pDrowned;
		}

		public void tick() {
			LivingEntity livingentity = this.drowned.getTarget();
			if (this.drowned.wantsToSwim() && this.drowned.isInWater()) {
				if (livingentity != null && livingentity.getY() > this.drowned.getY() || this.drowned.searchingForLand) {
					this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add(0.0D, 0.002D, 0.0D));
				}

				if (this.operation != MoveControl.Operation.MOVE_TO || this.drowned.getNavigation().isDone()) {
					this.drowned.setSpeed(0.0F);
					return;
				}

				double d0 = this.wantedX - this.drowned.getX();
				double d1 = this.wantedY - this.drowned.getY();
				double d2 = this.wantedZ - this.drowned.getZ();
				double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
				d1 /= d3;

				float f = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
				this.drowned.setYRot(this.rotlerp(this.drowned.getYRot(), f, 90.0F));
				this.drowned.yBodyRot = this.drowned.getYRot();

				float f1 = (float)(this.speedModifier * this.drowned.getAttributeValue(Attributes.MOVEMENT_SPEED));
				float f2 = Mth.lerp(0.125F, this.drowned.getSpeed(), f1);
				this.drowned.setSpeed(f2);

				this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add(
						(double)f2 * d0 * 0.005D,
						(double)f2 * d1 * 0.1D,
						(double)f2 * d2 * 0.005D
				));
			} else {
				if (!this.drowned.onGround()) {
					this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add(0.0D, -0.008D, 0.0D));
				}
				super.tick();
			}
		}
	}
}