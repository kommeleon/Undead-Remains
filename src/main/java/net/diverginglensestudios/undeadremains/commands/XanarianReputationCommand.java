/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.diverginglensestudios.undeadremains.playerData.xanarianreputation.PlayerXanarianReputationProvider;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;


public class XanarianReputationCommand {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(
				Commands.literal("xanarianreputation")
						// no .requires(...) → usable without cheats
						.executes(context -> {
							ServerPlayer player =
									context.getSource().getPlayerOrException();

							player.getCapability(PlayerXanarianReputationProvider.PLAYER_XANARIAN_REPUTATION
							).ifPresent(rep -> {
								int value = rep.getXanarianReputation();
								player.displayClientMessage(
										Component.literal("Your Xanarian Reputation is "+value), true);
							});

							return 1;
						})
		);
	}
}

