/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.custom.Other;

import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.diverginglensestudios.undeadremains.particles.ModParticles;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class MetaturboniteGrenadeProjectileEntity extends ThrowableItemProjectile {
	public MetaturboniteGrenadeProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public MetaturboniteGrenadeProjectileEntity(Level pLevel) {
		super(ModEntities.METATURBONITE_GRENADE_PROJECTILE.get(), pLevel);
	}

	public MetaturboniteGrenadeProjectileEntity(Level pLevel, LivingEntity livingEntity) {
		super(ModEntities.METATURBONITE_GRENADE_PROJECTILE.get(), livingEntity, pLevel);
	}

	@Override
	protected Item getDefaultItem() {
		return ModItems.METATURBONITE_GRENADE.get();
	}

	@Override
	protected void onHitBlock(BlockHitResult result) {
		super.onHitBlock(result);
		if (!this.level().isClientSide) {
			this.level().explode(this, this.getX(), this.getY(), this.getZ(), 3.0F, Level.ExplosionInteraction.TNT);
			this.discard();
		}
	}
}
