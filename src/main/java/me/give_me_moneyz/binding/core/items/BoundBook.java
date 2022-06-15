package me.give_me_moneyz.binding.core.items;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BoundBook extends Item {
    public BoundBook(Item.Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, world, tooltip, flagIn);
        if(Screen.hasShiftDown() && Component.Serializer.fromJson(stack.getOrCreateTag().getString("name")) != null) {
            tooltip.add(Component.translatable("tooltip.binding.bound_book", Component.Serializer.fromJson(stack.getOrCreateTag().getString("name")).withStyle(ChatFormatting.AQUA), Component.Serializer.fromJson(stack.getOrCreateTag().getString("held_item")).withStyle(ChatFormatting.RED)));
        }
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level world = Objects.requireNonNull(pContext.getPlayer()).getCommandSenderWorld();
        Player player = pContext.getPlayer();
        CompoundTag nbt = pContext.getItemInHand().getOrCreateTag();
        if(!world.isClientSide) {
            Entity entity = EntityType.loadEntityRecursive(nbt.getCompound("entity"), world, e -> {
                e.moveTo(Vec3.upFromBottomCenterOf(pContext.getClickedPos(), 1));
                return e;
            });
            if(entity != null) world.addFreshEntity(entity);
            ItemStack newItem = new ItemStack(Items.ENCHANTED_BOOK);
            EnchantmentHelper.setEnchantments(Collections.singletonMap(Enchantments.BINDING_CURSE, 1), newItem);
            player.setItemInHand(pContext.getHand(), newItem);
        }
        return InteractionResult.SUCCESS;
    }
}
