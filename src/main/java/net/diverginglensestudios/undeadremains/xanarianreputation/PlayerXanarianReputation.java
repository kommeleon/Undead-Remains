/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.xanarianreputation;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;

public class PlayerXanarianReputation {
    private int xanarianreputation;
    private final int MIN_XANARIAN_REPUTATION = -100;
    private final int MAX_XANARIAN_REPUTATION = 100;

    public void addXanarianReputation(ServerPlayer player,int add){
        this.setXanarianReputation(player,this.getXanarianReputation()+add);
    }
    public void subXanarianReputation(ServerPlayer player,int subtract){
        this.setXanarianReputation(player,this.getXanarianReputation()-subtract);
    }
    public void setXanarianReputation(ServerPlayer player, int value) {
        int old = xanarianreputation;
        xanarianreputation = Mth.clamp(value, MIN_XANARIAN_REPUTATION, MAX_XANARIAN_REPUTATION);

        if (old != xanarianreputation) {
            onReputationChanged(player, old, xanarianreputation);
        }
    }
    public int getXanarianReputation() {
        return xanarianreputation;
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
    private void onReputationChanged(ServerPlayer player, int oldValue, int newValue) {
        int delta = newValue - oldValue;

        Component msg = Component.literal(
                "Xanarian Reputation is now " + this.getXanarianReputation());

        player.displayClientMessage(msg,true);
    }
}
