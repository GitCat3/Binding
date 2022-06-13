package me.give_me_moneyz.binding.core.events;

import me.give_me_moneyz.binding.Binding;
import me.give_me_moneyz.binding.core.init.EnchantmentInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Binding.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AllayEnchantmentTick {
    @SubscribeEvent
    public static void doMagnet(final TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Level world = player.getCommandSenderWorld();
        if(player.hasItemInSlot(EquipmentSlot.CHEST) && EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ALLAY_ENCHANT.get(), player.getItemBySlot(EquipmentSlot.CHEST)) > 0) {
            List<ItemEntity> entities = world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(player.getX(), player.getY(), player.getZ()), 6, 6, 6));
            System.out.println(entities);
        }
    }
}
