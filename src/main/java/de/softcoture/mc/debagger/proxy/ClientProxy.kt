package de.softcoture.mc.debagger.proxy

import de.softcoture.mc.debagger.blocks.ModBlocks
import de.softcoture.mc.debagger.items.ModItems

class ClientProxy : CommonProxy() {
    override fun init() {
        super.init()
        ModItems.registerRenders()
        ModBlocks.registerRenders()
    }

}