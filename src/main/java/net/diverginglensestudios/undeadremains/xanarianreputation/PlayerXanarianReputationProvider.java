/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.xanarianreputation;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerXanarianReputationProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerXanarianReputation> PLAYER_XANARIAN_REPUTATION = CapabilityManager.get(new CapabilityToken<PlayerXanarianReputation>() {});

    private PlayerXanarianReputation xanarianReputation = null;
    private final LazyOptional<PlayerXanarianReputation> optional =LazyOptional.of(this::createPlayerXanarianReputation);

    private  PlayerXanarianReputation createPlayerXanarianReputation() {
        if (this.xanarianReputation == null){
            this.xanarianReputation = new PlayerXanarianReputation();
        }
        return this.xanarianReputation;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_XANARIAN_REPUTATION){
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerXanarianReputation().saveNBTdata(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerXanarianReputation().loadNBTdata(nbt);

    }
}
