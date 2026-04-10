package net.diverginglensestudios.undeadremains.block.custom;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;

public class ModTooltipBlock extends Block {

    private final String tooltipKey;

    public ModTooltipBlock(Properties properties, String tooltipKey) {
        super(properties);
        this.tooltipKey = tooltipKey;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltipComponents,
            TooltipFlag isAdvanced) {
        tooltipComponents.add(Component.translatable(this.tooltipKey).withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);

    }
}