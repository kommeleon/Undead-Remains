package net.diverginglensestudios.undeadremains.xanarianreputation;

import net.minecraft.nbt.CompoundTag;

public class PlayerXanarianReputation {
    private int xanarianreputation;
    private final int MIN_XANARIAN_REPUTATION = -100;
    private final int MAX_XANARIAN_REPUTATION = 100;

    public void addXanarianReputation(int add){
        this.xanarianreputation = Math.min(xanarianreputation + add, MAX_XANARIAN_REPUTATION);
    }
    public void subXanarianReputation(int subtract){
        this.xanarianreputation = Math.max(xanarianreputation - subtract, MIN_XANARIAN_REPUTATION);
    }
    public void copyFrom(PlayerXanarianReputation source){
        this.xanarianreputation = source.xanarianreputation;
    }
    public void saveNBTdata(CompoundTag nbt){
        nbt.putInt("xanarianreputation",xanarianreputation);
    }
    public void loadNBTdata(CompoundTag nbt){
        xanarianreputation = nbt.getInt("xanarianreputation");
    }
}
