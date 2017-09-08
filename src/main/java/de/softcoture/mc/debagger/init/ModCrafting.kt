package de.softcoture.mc.debagger.init

import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.registry.GameRegistry

object ModCrafting {
    fun register() {
        GameRegistry.addShapedRecipe(ItemStack(ModBlocks.blockRuby),
                "RRR","RRR","RRR",
                'R', ModItems.ruby)
    }
}