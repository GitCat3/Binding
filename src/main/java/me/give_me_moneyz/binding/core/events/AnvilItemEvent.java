package me.give_me_moneyz.binding.core.events;

import me.give_me_moneyz.binding.Binding;
import me.give_me_moneyz.binding.core.init.EnchantmentInit;
import me.give_me_moneyz.binding.core.init.ItemInit;
import me.give_me_moneyz.binding.util.ItemUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Binding.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AnvilItemEvent {
    @SubscribeEvent
    public static void ItemsInAnvil(final AnvilUpdateEvent event) {
        if(ItemUtils.CHESPLATES.contains(event.getLeft().getItem()) && event.getRight().getItem() == ItemInit.BOUND_BOOK.get()) {
            System.out.println(Component.Serializer.fromJson(event.getRight().getOrCreateTag().getString("held_item")));
            if(!Objects.requireNonNull(Component.Serializer.fromJson(event.getRight().getOrCreateTag().getString("held_item"))).toString().equals(Items.AIR.asItem().toString())) {
                ItemStack newitem = event.getLeft().copy();
                newitem.enchant(EnchantmentInit.ALLAY_ENCHANT.get(), 1);
                event.setOutput(newitem);
                event.setCost(5);
            }
        }
    }
}
