/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.diverginglensestudios.undeadremains.playerData.xanarianreputation.PlayerXanarianReputationProvider;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class SetXanarianReputationCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("setXanarianReputation")
            .requires(source -> source.hasPermission(2)) // OP level
            .then(Commands.argument("player", EntityArgument.player())
            .then(Commands.argument("value", IntegerArgumentType.integer(-100, 100))
            .executes(context -> {ServerPlayer player =
            EntityArgument.getPlayer(context, "player");
            int value = IntegerArgumentType.getInteger(context, "value");
            player.getCapability(PlayerXanarianReputationProvider.PLAYER_XANARIAN_REPUTATION)
            .ifPresent(rep -> {
                rep.setXanarianReputation(player,value);
            });
            context.getSource().sendSuccess(() -> Component.literal("Set Xanarian Reputation of " + player.getName().getString() + " to " + value), true);
            return 1;
            }
                    )
                )
            )
        );
    }
}