package me.give_me_moneyz.binding.core.init;

import me.give_me_moneyz.binding.Binding;
import me.give_me_moneyz.binding.core.packets.KeybindPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Binding.MOD_ID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    private PacketHandler() {

    }

    public static void init() {
        int index = 0;
        INSTANCE.messageBuilder(KeybindPacket.class, ++index, NetworkDirection.PLAY_TO_SERVER).encoder(KeybindPacket::encode).decoder(KeybindPacket::new).consumer(KeybindPacket::handle).add();
    }
}
