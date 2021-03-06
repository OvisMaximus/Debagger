package de.softcoture.mc.debagger.init

import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.registry.GameRegistry

object ModCrafting {
    fun register() {
        GameRegistry.addShapedRecipe(ItemStack(ModBlocks.BLOCK_RUBY),
                "RRR","RRR","RRR",
                'R', ModItems.RUBY)
        GameRegistry.addShapelessRecipe(ItemStack(ModItems.RUBY, 9),
                ModBlocks.BLOCK_RUBY)
        GameRegistry.addSmelting(Blocks.OBSIDIAN,
                ItemStack(ModItems.OBSIDIAN_INGOT),0.5F)
        GameRegistry.addShapedRecipe(ItemStack(ModBlocks.BLOCK_DEBAGGER_CLOSET),
                "WCW","IHI","WCW",
                'W', Blocks.PLANKS, 'C', Blocks.CHEST, 'I', Items.IRON_INGOT,
                'H', Blocks.HOPPER)
    }
}