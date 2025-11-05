package net.diverginglensestudios.undeadremains.entity.custom.Bosses;


import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.entity.ai.BetterRandomStrollGoal;
import net.diverginglensestudios.undeadremains.entity.ai.FourEyedXanarianAttackGoal;
import net.diverginglensestudios.undeadremains.entity.ai.SahnUzalAttackGoal;
import net.diverginglensestudios.undeadremains.entity.custom.Other.Cm_Falling_Block_Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import org.jetbrains.annotations.Nullable;

public class SahnUzalEntity extends Monster {
private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

private static final EntityDataAccessor<Boolean> ATTACKING =
SynchedEntityData.defineId(SahnUzalEntity.class, EntityDataSerializers.BOOLEAN);

private static final EntityDataAccessor<Boolean> SLEEPING =
SynchedEntityData.defineId(SahnUzalEntity.class, EntityDataSerializers.BOOLEAN);

private static final EntityDataAccessor<Integer> ATTACKTICKER =
SynchedEntityData.defineId(SahnUzalEntity.class, EntityDataSerializers.INT);

private static final EntityDataAccessor<Integer> TICKSUNTILHIT =
SynchedEntityData.defineId(SahnUzalEntity.class, EntityDataSerializers.INT);

private static final EntityDataAccessor<Integer> ATTACK_TYPE =
    SynchedEntityData.defineId(SahnUzalEntity.class, EntityDataSerializers.INT);


public boolean SahnUzalStabQuakeTriggered = false;
public SahnUzalEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
super(pEntityType, pLevel);
}
public enum AttackType {
    NONE,
    SLASH1,
    SLASH2,
    FLOOR_STAB,
    SLAM
}
public final AnimationState idleAnimationState = new AnimationState();
private int idleAnimationTimeout = 0;
public final AnimationState slash1AnimationState = new AnimationState();
public final AnimationState slash2AnimationState = new AnimationState();
public final AnimationState floorStabAnimationState = new AnimationState();
public final AnimationState slamAnimationState = new AnimationState();
public final AnimationState slamSlashAnimationState = new AnimationState();
public final AnimationState chargeUpAnimationState = new AnimationState();
private int quakeRadius = 0;
private int quakeMaxRadius = 0;
private int quakeDelay = 0;
private boolean quakeActive = false;

public Integer getAttackTicker() {
    return this.entityData.get(ATTACKTICKER);
}

public void setAttackTicker(Integer ticks) {
    this.entityData.set(ATTACKTICKER, ticks);
}

public AttackType getAttackType() {
    return AttackType.values()[this.entityData.get(ATTACK_TYPE)];
}

public void setAttackType(AttackType type) {
    this.entityData.set(ATTACK_TYPE, type.ordinal());
}

public Integer getTicksUntilHit() {
    return this.entityData.get(TICKSUNTILHIT);
}

public void setTicksUntilHit(Integer ticks) {
    this.entityData.set(TICKSUNTILHIT, ticks);
}

public void readAdditionalSaveData(CompoundTag pCompound) {
    super.readAdditionalSaveData(pCompound);
    if (this.hasCustomName()) {
        this.bossEvent.setName(this.getDisplayName());
    }
}

public void setCustomName(@Nullable Component pName) {
    super.setCustomName(pName);
    this.bossEvent.setName(this.getDisplayName());
}

public void startSeenByPlayer(ServerPlayer pPlayer) {
    super.startSeenByPlayer(pPlayer);
    this.bossEvent.addPlayer(pPlayer);
}

@Override
public void tick() {
    super.tick();
    if (this.getHealth() < this.getMaxHealth() && this.getHealth() > 0){ //checks if boss health is smaller than Max and larger than 1
            this.heal(1);
            //this.setHealth(this.getHealth()+0.5f); //Heals the boss by 0.5 health every tick
            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth()); //Updates the bossbar every tick

        }
    if(this.level().isClientSide()) {
        setupAnimationStates();
        this.slash1AnimationState.animateWhen(this.getAttackTicker() > 0& this.getAttackType() == AttackType.SLASH1, this.tickCount);
        this.slash2AnimationState.animateWhen(this.getAttackTicker() > 0 && this.getAttackType() == AttackType.SLASH2, this.tickCount);
        this.floorStabAnimationState.animateWhen(this.getAttackTicker() > 0 && this.getAttackType() == AttackType.FLOOR_STAB, this.tickCount);
        this.slamAnimationState.animateWhen(this.getAttackTicker() > 0 && this.getAttackType() == AttackType.SLAM, this.tickCount);
    }else {
        if (this.getAttackTicker()>0){
            this.setAttackTicker(getAttackTicker()-1);//if the ticker is more than 0, then it gets reduced by 1 every tick
        if (this.getTicksUntilHit()>0){
            this.setTicksUntilHit(getTicksUntilHit()-1);//if the ticker is more than 0, then it gets reduced by 1 every tick
            }
        }
    }
    if (this.getAttackType() == AttackType.FLOOR_STAB && this.getTicksUntilHit() == 1) {
            doEarthquake(level(), blockPosition(), 6);
    }
if (quakeActive && !level().isClientSide() && quakeDelay-- <= 0) {
        createRing(level(), blockPosition(), quakeRadius);
        quakeRadius++;
        quakeDelay = 5; // 5 ticks between rings
        if (quakeRadius > quakeMaxRadius) {
            quakeActive = false;
    }
}
}
public void doEarthquake(Level level, BlockPos center, int radius) {
    if (level.isClientSide()) return;
    this.quakeActive = true;
    this.quakeRadius = 0;
    this.quakeMaxRadius = radius;
    this.quakeDelay = 0;
}

private void createRing(Level level, BlockPos center, int radius) {
    int baseY = center.getY() - 1; // hit blocks below feet

    for (int x = -radius; x <= radius; x++) {
        for (int z = -radius; z <= radius; z++) {
            double dist = Math.sqrt(x * x + z * z);
            if (Math.abs(dist - radius) < 0.5) {
                BlockPos pos = center.offset(x, 0, z);

                // Find the first solid block under the surface (so we don’t hit air)
                BlockPos groundPos = findSolidGround(level, pos, baseY);

                if (groundPos != null) {
                    BlockState state = level.getBlockState(groundPos);

                    // Skip bedrock etc
                    if (!state.isAir() && state.getDestroySpeed(level, groundPos) >= 0) {
                        Cm_Falling_Block_Entity falling = new Cm_Falling_Block_Entity(
                        level,
                        groundPos.getX() + 0.5D,
                        groundPos.getY(),
                        groundPos.getZ() + 0.5D,
                        state,
                        10 // duration before it disappears
                        );
                        falling.setDeltaMovement(0, 0.5D, 0); // upward launch
                        level.addFreshEntity(falling);
                    }
                }
            }
        }
    }
}

@Nullable
private BlockPos findSolidGround(Level level, BlockPos pos, int startY) {
    for (int y = startY; y > startY - 5; y--) { // search a few blocks down
        BlockPos check = new BlockPos(pos.getX(), y, pos.getZ());
        if (level.getBlockState(check).isSolid()) {
            return check;
        }
    }
    return null;
}
private void setupAnimationStates() { //I dont really understand this part but it works
    if(this.idleAnimationTimeout <= 0) {
        this.idleAnimationTimeout = this.random.nextInt(40) + 80;
        this.idleAnimationState.start(this.tickCount);
    } else {
        --this.idleAnimationTimeout;
    }
}

public void setAttacking(boolean attacking) { //command to set entity to attacking state
    this.entityData.set(ATTACKING, attacking);
}

public boolean isAttacking() {  //command to check if entity is attacking
    return this.entityData.get(ATTACKING);
}

@Override
protected void defineSynchedData() { //Sets default values for entity data
    super.defineSynchedData();
    this.entityData.define(ATTACKING, false);
    this.entityData.define(ATTACKTICKER, 0);
    this.entityData.define(TICKSUNTILHIT, 0);
    this.entityData.define(ATTACK_TYPE, AttackType.NONE.ordinal());
}

@Override
protected void registerGoals() {
this.goalSelector.addGoal(0, new FloatGoal(this));
this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
this.goalSelector.addGoal(3, new SahnUzalAttackGoal(this, 1.25D, true));
this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 5f));
this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
}

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 250D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR_TOUGHNESS, 1f)
                .add(Attributes.ATTACK_KNOCKBACK, 2f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 2f)
                .add(Attributes.ATTACK_DAMAGE, 10f);
    }

public void stopSeenByPlayer(ServerPlayer pPlayer) {    //Add the given player to the list of players tracking 
    super.stopSeenByPlayer(pPlayer);                    //this entity. For instance, a player may track a
    this.bossEvent.removePlayer(pPlayer);               //boss in order to view its associated boss bar.
}
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.HOGLIN_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.RAVAGER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.DOLPHIN_DEATH;
    }
}