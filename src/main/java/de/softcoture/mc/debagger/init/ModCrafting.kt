package de.softcoture.mc.debagger.init

import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.registry.GameRegistry

object ModCrafting {
    fun register() {
        GameRegistry.addShapedRecipe(ItemStack(ModBlocks.blockRuby),
                "RRR","RRR","RRR",
                'R', ModItems.ruby)
        GameRegistry.addShapelessRecipe(ItemStack(ModItems.ruby, 9),
                ModBlocks.blockRuby)
        GameRegistry.addSmelting(Blocks.OBSIDIAN,
                ItemStack(ModItems.obsidianIngot),0.5F)
    }
}