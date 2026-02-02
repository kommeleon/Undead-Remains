/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.effects;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
	public static final DeferredRegister<Potion> POTIONS
			= DeferredRegister.create(ForgeRegistries.POTIONS, UndeadRemains.MOD_ID);

	public static final RegistryObject<Potion> FOSSILIZED_HEART_POTION = POTIONS.register("fossilized_heart_potion",
			() -> new Potion(new MobEffectInstance(ModEffects.FOSSILIZED_HEART.get(), 200, 0)));


	public static void register(IEventBus eventBus) {
		POTIONS.register(eventBus);
	}
}