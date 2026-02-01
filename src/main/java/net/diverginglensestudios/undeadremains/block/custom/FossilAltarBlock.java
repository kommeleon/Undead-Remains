/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.block.custom;


import javax.annotation.Nullable;

import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.block.entity.ModBlockEntities;
import net.diverginglensestudios.undeadremains.block.entity.XanarianGatewayBlockEntity;
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

public class FossilAltarBlock extends BaseEntityBlock{
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

        if (!player.canChangeDimensions()) {
            return InteractionResult.CONSUME;
        }

        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {

            BlockEntity be = level.getBlockEntity(clickedPos);
            if (!(be instanceof XanarianGatewayBlockEntity gateway)) {
                return InteractionResult.PASS;
            }

            BlockPos playerPos = serverPlayer.blockPosition();

            if (!playerPos.below().equals(clickedPos)) {

                NetworkHooks.openScreen(serverPlayer, gateway, clickedPos);
                serverPlayer.displayClientMessage(
                        Component.literal("Stand on the teleporter to teleport"), true);

                return InteractionResult.SUCCESS;
            }

            if (!gateway.canTeleport()) {
                serverPlayer.displayClientMessage(
                        Component.literal("The gateway has no remaining charge"), true);
                return InteractionResult.SUCCESS;
            }

            MinecraftServer server = serverPlayer.getServer();
            if (server == null) return InteractionResult.PASS;

            ResourceKey<Level> targetDim =
                    level.dimension() == ModDimensions.FOSSILDIM_LEVEL_KEY
                            ? Level.OVERWORLD
                            : ModDimensions.FOSSILDIM_LEVEL_KEY;

            ServerLevel targetWorld = server.getLevel(targetDim);
            if (targetWorld == null) return InteractionResult.PASS;

            gateway.consumeCharge();

            serverPlayer.changeDimension(
                    targetWorld,
                    new ModFossilTeleporter(playerPos.below(), ModBlocks.FOSSIL_ALTAR.get())
            );
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new XanarianGatewayBlockEntity(pPos, pState);
    }
@Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()) {
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.XANARIAN_GATEWAY_BE.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
                
    }
}
