package me.give_me_moneyz.binding.core.packets;

import me.give_me_moneyz.binding.core.capability.MagnetismCapability;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;

public class KeybindPacket {
    public KeybindPacket() {

    }

    public KeybindPacket(FriendlyByteBuf packetBuffer) {

    }

    public static void encode(KeybindPacket keybindpacket, FriendlyByteBuf packetBuffer) {

    }

    public static void handle(KeybindPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Player player = ctx.get().getSender();
            assert player != null;
            player.getCapability(MagnetismCapability.INSTANCE).orElseThrow(() -> new RuntimeException("capability not found")).setmagneting(!player.getCapability(MagnetismCapability.INSTANCE).orElseThrow(() -> new RuntimeException("capability not found")).ismagneting());
        });
        ctx.get().setPacketHandled(true);
    }
}
