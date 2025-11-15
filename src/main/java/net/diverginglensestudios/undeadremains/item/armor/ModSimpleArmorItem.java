/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.item.armor;

import com.google.common.collect.ImmutableMap;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;

public class ModSimpleArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP = (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
            // .put(ModArmorMaterials.FOSSIL, new MobEffectInstance(MobEffects.NIGHT_VISION,
            // 230, 1,
            // false,false, true))
            .put(ModArmorMaterials.RARE_FOSSIL, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1,
                    false, false, true))
            .put(ModArmorMaterials.METATORBERNITE, new MobEffectInstance(MobEffects.CONFUSION, 200, 1,
                    false, false, true))
            .put(ModArmorMaterials.SCUTE_MODIFIED_FOSSIL, new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1, 1,
                    false, false, false))
            .put(ModArmorMaterials.CLOCK_MODIFIED_FOSSIL, new MobEffectInstance(MobEffects.GLOWING, 10, 1,
                    false, false, false))
            .build();

    public ModSimpleArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {

            // Check the leggings slot (index 1) and apply the SCUTE_MODIFIED_FOSSIL effect
            // directly
            ItemStack leggingsStack = player.getInventory().getArmor(1);
            if (!leggingsStack.isEmpty() && leggingsStack == stack && leggingsStack.getItem() instanceof ArmorItem) {
                ArmorItem leggingsItem = (ArmorItem) leggingsStack.getItem();
                if (leggingsItem.getMaterial() == ModArmorMaterials.SCUTE_MODIFIED_FOSSIL) {
                    MobEffectInstance effect = MATERIAL_TO_EFFECT_MAP.get(ModArmorMaterials.SCUTE_MODIFIED_FOSSIL);
                    if (effect != null) {
                        player.addEffect(new MobEffectInstance(effect));
                    }
                }
            }
            ItemStack chestplateStack = player.getInventory().getArmor(2);
            if (!chestplateStack.isEmpty()
                    && chestplateStack == stack
                    && chestplateStack.getItem() instanceof ArmorItem chestplateItem) {
                if (chestplateItem.getMaterial() == ModArmorMaterials.CLOCK_MODIFIED_FOSSIL) {
                    boolean isDay = player.level().isDay();
                    boolean isNight = !isDay;
                    if (isDay) {
                        player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2, 0, false, false, false));
                    } else if (isNight) {
                        player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 2, 0, false, false, false));
                    }
                }
            }
        }

        // Preserve existing full-set checks and effects
        if (hasFullSuitOfArmorOn(player)) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial,
            MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if (hasCorrectArmorOn(mapArmorMaterial, player)) {
            player.addEffect(new MobEffectInstance(mapStatusEffect));
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {

        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
