package me.give_me_moneyz.binding.core.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class AllayEnchantment extends Enchantment {

    public AllayEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot... equipmentSlot) {
        super(rarity, category, equipmentSlot);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }
}
