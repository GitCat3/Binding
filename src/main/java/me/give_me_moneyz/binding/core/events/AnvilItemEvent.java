package me.give_me_moneyz.binding.core.events;

import me.give_me_moneyz.binding.Binding;
import me.give_me_moneyz.binding.core.init.EnchantmentInit;
import me.give_me_moneyz.binding.core.init.ItemInit;
import me.give_me_moneyz.binding.util.ItemUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Binding.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AnvilItemEvent {
    @SubscribeEvent
    public static void ItemsInAnvil(final AnvilUpdateEvent event) {
        if(ItemUtils.CHESPLATES.contains(event.getLeft().getItem()) && event.getRight().getItem() == ItemInit.BOUND_BOOK.get()) {
            if(!Objects.equals(Component.Serializer.fromJson(event.getRight().getOrCreateTag().getString("held_item")), Component.empty())) {
                ItemStack newitem = event.getLeft().copy();
                newitem.enchant(EnchantmentInit.ALLAY_ENCHANT.get(), 1);
                newitem.getOrCreateTag().putString("magnet_item", event.getRight().getOrCreateTag().getString("held_item"));
                event.setOutput(newitem);
                event.setCost(5);
            }
        }
    }
}
