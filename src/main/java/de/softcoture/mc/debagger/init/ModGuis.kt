package de.softcoture.mc.debagger.init

import de.softcoture.mc.debagger.instance
import de.softcoture.mc.debagger.gui.GuiHandler
import net.minecraftforge.fml.common.network.NetworkRegistry

object ModGuis {
    fun register () {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, GuiHandler())
    }
}