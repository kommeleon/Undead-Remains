/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.effects;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.effects.custom.FossilVisionEffect;
import net.diverginglensestudios.undeadremains.effects.custom.FossilizedHeartEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, UndeadRemains.MOD_ID);

    public static final RegistryObject<MobEffect> FOSSILIZED_HEART = MOB_EFFECTS.register("fossilized_heart",
            () -> new FossilizedHeartEffect(MobEffectCategory.HARMFUL, 3124687));

    public static final RegistryObject<MobEffect> FOSSIL_VISION = MOB_EFFECTS.register("fossil_vision",
            () -> new FossilVisionEffect(MobEffectCategory.BENEFICIAL, 3124687));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
