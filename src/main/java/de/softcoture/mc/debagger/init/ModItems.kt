package de.softcoture.mc.debagger.init

import de.softcoture.mc.debagger.items.ItemObsidianIngot
import de.softcoture.mc.debagger.items.ItemRuby
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.fml.common.registry.GameRegistry

object ModItems {

    var obsidianIngot: Item? = null
    var ruby: Item? = null

    fun init() {
        obsidianIngot = ItemObsidianIngot()
        ruby = ItemRuby()
    }

    fun register () {
        GameRegistry.register(obsidianIngot)
        GameRegistry.register(ruby)
    }

    fun registerRenders() {
        registerRender(obsidianIngot)
        registerRender(ruby)
    }

    private fun registerRender(item: Item?) {
        if (item == null) return
        val registryName = item.registryName?.toString() ?: item.toString()
        val resourceLocation = ModelResourceLocation(registryName, "inventory")
        val mesher = Minecraft.getMinecraft().renderItem.itemModelMesher
        mesher.register(item, 0, resourceLocation)
    }
}

