package net.diverginglensestudios.undeadremains.item.custom;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ModTooltipItem extends Item {
    
    private final String tooltipKey;

    public ModTooltipItem(Properties properties, String tooltipKey) {
        super(properties);
        this.tooltipKey = tooltipKey;
    }

    @Override
    public void appendHoverText(ItemStack stack,@Nullable Level level,List<Component> tooltipComponents,TooltipFlag isAdvanced) {
        tooltipComponents.add(Component.translatable(this.tooltipKey));
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
}