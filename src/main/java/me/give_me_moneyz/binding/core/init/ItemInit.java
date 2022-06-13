package me.give_me_moneyz.binding.core.init;

import me.give_me_moneyz.binding.Binding;
import me.give_me_moneyz.binding.core.items.BoundBook;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Binding.MOD_ID);
    public static final RegistryObject<BoundBook> BOUND_BOOK = ITEMS.register("bound_book", () -> new BoundBook(new Item.Properties()));
}
