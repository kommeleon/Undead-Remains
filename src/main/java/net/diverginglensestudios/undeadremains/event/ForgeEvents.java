/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.event;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.VanillaGameEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UndeadRemains.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

	@SubscribeEvent
	public static void onVanillaGameEvent(VanillaGameEvent event) {
		Entity cause = event.getCause();
		if (!(cause instanceof Player))
			return;
		Player player = (Player) cause;

		ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
		if (boots == null || boots.isEmpty())
			return;

		if (!boots.is(ModItems.ECHO_SHARD_MODIFIED_FOSSIL_BOOTS.get()))
			return;

		GameEvent vanillaType = event.getVanillaEvent();
		if (vanillaType == GameEvent.STEP || vanillaType == GameEvent.HIT_GROUND) {
			event.setCanceled(true);
		}
	}
}
