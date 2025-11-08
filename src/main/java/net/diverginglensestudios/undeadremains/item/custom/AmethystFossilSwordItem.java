/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/


package net.diverginglensestudios.undeadremains.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;

public class AmethystFossilSwordItem extends SwordItem {

    public AmethystFossilSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Apply glowing effect for 5 seconds (100 ticks)
        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0), attacker);

        // Optionally damage the sword like usual
        stack.hurtAndBreak(1, attacker, (p) -> p.broadcastBreakEvent(p.getUsedItemHand()));

        return true;
    }
}