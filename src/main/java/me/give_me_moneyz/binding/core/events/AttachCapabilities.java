package me.give_me_moneyz.binding.core.events;

import me.give_me_moneyz.binding.Binding;
import me.give_me_moneyz.binding.core.capability.MagnetismCapability;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = Binding.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AttachCapabilities {
    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof Player) {
            event.addCapability(new ResourceLocation(Binding.MOD_ID, "magnetism"), new ICapabilityProvider() {
                final LazyOptional<MagnetismCapability> supplier = LazyOptional.of(() -> {
                    MagnetismCapability inst = new MagnetismCapability();
                    inst.setPlayer((Player) event.getObject());
                    return inst;
                });

                @Nonnull
                @Override
                public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
                    if(cap == MagnetismCapability.INSTANCE) {
                        return supplier.cast();
                    }
                    return LazyOptional.empty();
                }
            });
        }
    }
}
