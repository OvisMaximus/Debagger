package de.softcoture.mc.debagger.proxy

import de.softcoture.mc.debagger.init.ModBlocks
import de.softcoture.mc.debagger.init.ModCrafting
import de.softcoture.mc.debagger.init.ModItems

abstract class CommonProxy {
    open fun preInit() {
        // Items have to be registered before blocks so that blocks may drop items when harvested
        ModItems.register()
        ModBlocks.register()
    }

    open fun init() {
        ModCrafting.register()
    }

    open fun postInit() {
    }
}