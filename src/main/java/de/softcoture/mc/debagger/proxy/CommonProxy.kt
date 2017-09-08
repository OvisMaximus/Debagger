package de.softcoture.mc.debagger.proxy

import de.softcoture.mc.debagger.blocks.ModBlocks
import de.softcoture.mc.debagger.items.ModItems

abstract class CommonProxy {
    open fun preInit() {
        ModItems.init()
        ModItems.register()

        ModBlocks.init()
        ModBlocks.register()
    }

    open fun init() {
    }

    open fun postInit() {
    }
}