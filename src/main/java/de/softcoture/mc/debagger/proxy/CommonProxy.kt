package de.softcoture.mc.debagger.proxy

import de.softcoture.mc.debagger.init.*

abstract class CommonProxy {
    open fun preInit() {
        // Items have to be registered before blocks so that blocks may drop items when harvested
        ModItems.register()
        ModBlocks.register()
        ModTileEntities.register()
    }

    open fun init() {
        ModCrafting.register()
        ModGuis.register()
    }

    open fun postInit() {
    }
}