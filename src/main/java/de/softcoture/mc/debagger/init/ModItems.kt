package de.softcoture.mc.debagger.init

import de.softcoture.mc.debagger.items.ItemObsidianIngot
import de.softcoture.mc.debagger.items.ItemRuby
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.fml.common.registry.GameRegistry

object ModItems {

    val OBSIDIAN_INGOT: Item = ItemObsidianIngot()
    val RUBY: Item = ItemRuby()

    fun register () {
        GameRegistry.register(OBSIDIAN_INGOT)
        GameRegistry.register(RUBY)
    }

    fun registerRenders() {
        registerRender(OBSIDIAN_INGOT)
        registerRender(RUBY)
    }

    private fun registerRender(item: Item) {
        val registryName = item.registryName?.toString() ?: item.toString()
        val resourceLocation = ModelResourceLocation(registryName, "inventory")
        val mesher = Minecraft.getMinecraft().renderItem.itemModelMesher
        mesher.register(item, 0, resourceLocation)
    }
}

