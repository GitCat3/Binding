package me.give_me_moneyz.binding.core.init;

import me.give_me_moneyz.binding.Binding;
import me.give_me_moneyz.binding.core.enchantments.AllayEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Binding.MOD_ID);
    public static RegistryObject<Enchantment> MAGNET_ENCHANT = ENCHANTMENTS.register("magnet_enchant", () -> new AllayEnchantment(Enchantment.Rarity.VERY_RARE, null, EquipmentSlot.CHEST));
    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
