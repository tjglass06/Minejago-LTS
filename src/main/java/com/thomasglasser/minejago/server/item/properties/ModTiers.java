package com.thomasglasser.minejago.server.item.properties;

import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullSupplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ModTiers
{
    public static final ForgeTier BONE_TIER = new ForgeTier(2, 150, 10.0f, 1.5f, 10, BlockTags.NEEDS_STONE_TOOL, () -> {
        return Ingredient.of(Tags.Items.BONES);
    });
}
