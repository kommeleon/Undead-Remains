/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.item.armor;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    FOSSIL("fossil", /* durability multiplier */26,
            /* armor values for all pieces */ new int[] { /* helmet */(int) 1.5f, /* chestplate */(int) 5.5f,
                    (int) 4.5f, 2 },
            /* enchantment value */ 25,
            /* equip sound */SoundEvents.ARMOR_EQUIP_GENERIC, /* toughness */0, /* knockback res */0f,
            /* 🤷‍♂️ */ () -> Ingredient.of(ModItems.FOSSIL.get())),

    RARE_FOSSIL("rare_fossil", 35, new int[] { 4, 9, 7, 4 }, 30,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 3f, 1f, () -> Ingredient.of(ModItems.RARE_FOSSIL.get())),

    METATORBERNITE("metatorbernite", 20, new int[] { 3, 8, 5, 2 }, 30,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 0.5f, 0, () -> Ingredient.of(ModItems.METATORBERNITE.get())),

    SUNGLASSES("sunglasses", 5, new int[] { 1, 1, 1, 1 }, 10,
            SoundEvents.ARMOR_EQUIP_LEATHER, 0.1f, 0f, () -> Ingredient.of(Items.GLASS)),

    LANGRITE("langrite", 5, new int[] { 4, 9, 7, 4 }, 25,
            SoundEvents.ARMOR_EQUIP_GOLD, 2.5f, 0.5f, () -> Ingredient.of(ModItems.LANGRITE_INGOT.get())),

    XANARIAN("xanarian", 20, new int[] { 2, 4, 3, 2 }, 25,
            SoundEvents.ARMOR_EQUIP_GOLD, 2f, 0f, () -> Ingredient.of(ModItems.XANARIAN_SPINE.get())),

    COW("cow", 20, new int[] { 1, 3, 2, 1 }, 25,
            SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f, () -> Ingredient.of(Items.LEATHER)),

    SCUTE_MODIFIED_FOSSIL("scute_modified_fossil", 26, new int[] { 1, 3, 3, 1 }, 25,
            SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.FOSSIL.get())),

    LIGHTNING_ROD_MODIFIED_FOSSIL("lightning_rod_modified_fossil", 26, new int[] { 2, 3, 3, 1 }, 25,
            SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.FOSSIL.get())),

    CLOCK_MODIFIED_FOSSIL("clock_modified_fossil", 26, new int[] { 2, 6, 3, 1 }, 25,
            SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.FOSSIL.get())),

    SCULK_SHARD_MODIFIED_FOSSIL("sculk_shard_modified_fossil", 26, new int[] { 2, 3, 3, (int) 2.5f }, 25,
            SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.FOSSIL.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue,
            SoundEvent equipSound,
            float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return UndeadRemains.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
