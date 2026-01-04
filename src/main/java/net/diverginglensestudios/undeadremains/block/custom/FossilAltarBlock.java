/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.block.custom;

import java.util.List;

import javax.annotation.Nullable;

import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.worldgen.dimension.ModDimensions;
import net.diverginglensestudios.undeadremains.worldgen.portal.ModFossilTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FossilAltarBlock extends Block{
    public FossilAltarBlock(Properties pProperties) {
        super(pProperties);
    }


    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState pState, Level level, BlockPos clickedPos, Player player,
            InteractionHand hand, BlockHitResult hit) {
        if (player.canChangeDimensions()) {
            if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
                BlockPos playerPos = serverPlayer.blockPosition();

                // Check if the player is standing on top of this altar block
                if (!playerPos.below().equals(clickedPos)) {
                    serverPlayer.displayClientMessage(Component.literal("Please stand on the teleporter"), true);
                    return InteractionResult.SUCCESS;
                }

                // Determine target dimension
                MinecraftServer server = serverPlayer.getServer();
                if (server == null)
                    return InteractionResult.PASS;

                ResourceKey<Level> targetDim = level.dimension() == ModDimensions.FOSSILDIM_LEVEL_KEY
                        ? Level.OVERWORLD
                        : ModDimensions.FOSSILDIM_LEVEL_KEY;

                ServerLevel targetWorld = server.getLevel(targetDim);
                if (targetWorld == null)
                    return InteractionResult.PASS;

                // Teleport using your custom teleporter
                serverPlayer.changeDimension(targetWorld,
                        new ModFossilTeleporter(playerPos.below(), ModBlocks.FOSSIL_ALTAR.get()));
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }
}

// public class FossilAltarBlock extends Block {
// public FossilAltarBlock(Properties pProperties) {
// super(pProperties);
// }
// public static final VoxelShape SHAPE = Block.box(1, 0, 3, 15, 16, 13);
//
// @Override
// public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos
// pPos, CollisionContext pContext) {
// return SHAPE;
// }
//
// @Override
// public RenderShape getRenderShape(BlockState pState) {
// return RenderShape.MODEL;
// }
//
// @Override
// public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
// Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
// if (pPlayer.canChangeDimensions()) {
// handleTestPortal(pPlayer, pPos);
// return InteractionResult.SUCCESS;
// } else {
// return InteractionResult.CONSUME;
// }
// }
//
// private void handleTestPortal(Entity player, BlockPos pPos) {
// if (player.level() instanceof ServerLevel serverlevel) {
// MinecraftServer minecraftserver = serverlevel.getServer();
// ResourceKey<Level> resourcekey = player.level().dimension() ==
// ModDimensions.FOSSILDIM_LEVEL_KEY ?
// Level.OVERWORLD : ModDimensions.FOSSILDIM_LEVEL_KEY;
// ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
// if (portalDimension != null && !player.isPassenger()) {
// if(resourcekey == ModDimensions.FOSSILDIM_LEVEL_KEY) {
// player.changeDimension(portalDimension, new ModFossilTeleporter(pPos));
// } else {
// player.changeDimension(portalDimension, new ModFossilTeleporter(pPos));
// }
// }
// }
// }
// }