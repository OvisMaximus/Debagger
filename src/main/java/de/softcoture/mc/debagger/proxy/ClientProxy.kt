package de.softcoture.mc.debagger.proxy

import de.softcoture.mc.debagger.init.ModBlocks
import de.softcoture.mc.debagger.init.ModItems

class ClientProxy : CommonProxy() {
    override fun init() {
        super.init()
        ModItems.registerRenders()
        ModBlocks.registerRenders()
    }

}