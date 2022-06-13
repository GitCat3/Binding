package me.give_me_moneyz.binding;

import me.give_me_moneyz.binding.core.init.EnchantmentInit;
import me.give_me_moneyz.binding.core.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("binding")
public class Binding {

    public static final String MOD_ID = "binding";

    public Binding() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(bus);
        EnchantmentInit.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
