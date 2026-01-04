package net.diverginglensestudios.undeadremains.block.multiblock;

import net.diverginglensestudios.undeadremains.block.multiblock.metatorberniteenricher.MetatorberniteEnricherPart;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class MultiblockHelper {
    public static boolean isMetatorberniteEnricherComplete(Level level, BlockPos center) {
        // Check a 3x3x3 cube around the controller
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos pos = center.offset(x, y, z);

                    if (x == 0 && y == 0 && z == 0) continue; // skip controller itself

                    if (!(level.getBlockState(pos).getBlock() instanceof MetatorberniteEnricherPart)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}