package me.give_me_moneyz.binding.core.events;

import me.give_me_moneyz.binding.Binding;
import me.give_me_moneyz.binding.core.capability.MagnetismCapability;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Binding.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterCapabilities {
    @SubscribeEvent
    public static void registerCapability(RegisterCapabilitiesEvent event) {
        event.register(MagnetismCapability.class);
    }
}
