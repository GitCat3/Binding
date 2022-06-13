package me.give_me_moneyz.binding.core.events;

import me.give_me_moneyz.binding.Binding;
import me.give_me_moneyz.binding.core.init.ItemInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = Binding.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EntityInteractEvent {
    @SubscribeEvent
    public static void CatchEntityInteraction(final PlayerInteractEvent.EntityInteract event) {
        Level world = event.getWorld();
        if(!world.isClientSide) {
            ItemStack item = event.getItemStack();
            Entity target = event.getTarget();
            Player player = event.getPlayer();
            CompoundTag nbt = new CompoundTag();
            ItemStack newitem = ItemInit.BOUND_BOOK.get().asItem().getDefaultInstance();
            Map<Enchantment, Integer> enchant = EnchantmentHelper.deserializeEnchantments(EnchantedBookItem.getEnchantments(item));
            if(target instanceof Allay allay && item.getItem() instanceof EnchantedBookItem && enchant.containsKey(Enchantments.BINDING_CURSE) && enchant.get(Enchantments.BINDING_CURSE) > 0) {
                target.save(nbt);
                player.setItemInHand(player.getUsedItemHand(), newitem);
                target.remove(Entity.RemovalReason.DISCARDED);
                CompoundTag newnbt = newitem.getOrCreateTag();
                newnbt.put("entity", nbt);
                if(!allay.getMainHandItem().isEmpty()) {
                    newnbt.putString("held_item", Component.Serializer.toJson(allay.getMainHandItem().getDisplayName()));
                }else {
                    newnbt.putString("held_item", Component.Serializer.toJson(Component.empty()));
                }
                newnbt.putString("name", Component.Serializer.toJson(target.getName()));
            }
        }
    }
}

