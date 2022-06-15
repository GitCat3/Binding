package me.give_me_moneyz.binding.core.events;

import com.mojang.blaze3d.platform.InputConstants;
import me.give_me_moneyz.binding.Binding;
import me.give_me_moneyz.binding.core.init.PacketHandler;
import me.give_me_moneyz.binding.core.packets.KeybindPacket;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Binding.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KeybindToggle {
    @SubscribeEvent
    public static void KeybindEvent(final InputEvent.KeyInputEvent event) {
        if(Binding.MAGNETISM.isActiveAndMatches(InputConstants.getKey(event.getKey(), event.getScanCode())) && event.getAction() == GLFW.GLFW_PRESS && Minecraft.getInstance().screen == null) {
            PacketHandler.INSTANCE.sendToServer(new KeybindPacket());
        }
    }
}
