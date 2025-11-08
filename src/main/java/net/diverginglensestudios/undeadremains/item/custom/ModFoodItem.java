/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/


package net.diverginglensestudios.undeadremains.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModFoodItem extends Item{
private int duration;
public ModFoodItem(Properties pProperties, int useDuration) {
            super(pProperties);
            duration=useDuration;
}

@Override 
public int getUseDuration(ItemStack pStack) {
        return duration;
}
}
