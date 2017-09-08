package de.softcoture.mc.debagger

import de.softcoture.mc.debagger.proxy.CommonProxy
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.Instance
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Instance
var instance:Debagger? = null

@SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
var proxy:CommonProxy? = null

@Mod(modid = MOD_ID, name = NAME, version = VERSION, acceptedMinecraftVersions = ACCEPTED_VERSIONS)
class Debagger {

    @EventHandler
    fun preInit(event:FMLPreInitializationEvent) {
        proxy!!.preInit()
    }

    @EventHandler
    fun Init(event: FMLInitializationEvent) {
        proxy!!.init()
    }

    @EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        proxy!!.postInit()
    }
}
