package de.softcoture.mc.debagger.items

import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.fml.common.registry.GameRegistry
import java.util.logging.Logger

object ModItems {

    var obsidianIngot: Item? = null

    fun init() {
        obsidianIngot = ItemObsidianIngot()
    }

    fun register () {
        GameRegistry.register(obsidianIngot)
    }

    fun registerRenders() {
        registerRender(obsidianIngot)
    }

    private fun registerRender(item: Item?) {
        if (item == null) return
        val registryName = item.registryName?.toString() ?: item.toString()
        val resourceLocation = ModelResourceLocation(registryName, "inventory")
        val mesher = Minecraft.getMinecraft().renderItem.itemModelMesher
        mesher.register(item, 0, resourceLocation)
    }
}

