package de.softcoture.mc.debagger.init

import de.softcoture.mc.debagger.blocks.BlockRuby
import net.minecraft.block.Block
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.fml.common.registry.GameRegistry


object ModBlocks {

    val BLOCK_RUBY: Block = BlockRuby()

    fun register () {
        registerBlock(BLOCK_RUBY)
    }

    private fun registerBlock(block: Block) {
        GameRegistry.register(block)
        val itemBlock = ItemBlock(block)
        itemBlock.setRegistryName(block.registryName)
        GameRegistry.register(itemBlock)
    }

    fun registerRenders() {
        registerRender(BLOCK_RUBY)
    }

    private fun registerRender(block: Block) {
        val registryName = block.registryName?.toString() ?: block.toString()
        val resourceLocation = ModelResourceLocation(registryName, "inventory")
        val mesher = Minecraft.getMinecraft().renderItem.itemModelMesher
        mesher.register(Item.getItemFromBlock(block), 0, resourceLocation)
    }
}

