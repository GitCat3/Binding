package me.give_me_moneyz.binding;

import com.mojang.blaze3d.platform.InputConstants;
import me.give_me_moneyz.binding.core.init.EnchantmentInit;
import me.give_me_moneyz.binding.core.init.ItemInit;
import me.give_me_moneyz.binding.core.init.PacketHandler;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("binding")
public class Binding {

    public static final String MOD_ID = "binding";
    public static final KeyMapping MAGNETISM = new KeyMapping("key.binding.magnetism", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_M, KeyMapping.CATEGORY_MISC);

    public Binding() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::registerKeyBinds);
        ItemInit.ITEMS.register(bus);
        EnchantmentInit.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
        PacketHandler.init();
    }

    public void registerKeyBinds (FMLClientSetupEvent e) {
        ClientRegistry.registerKeyBinding(MAGNETISM);
    }
}
