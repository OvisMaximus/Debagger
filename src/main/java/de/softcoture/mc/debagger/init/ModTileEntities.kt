package de.softcoture.mc.debagger.init


import de.softcoture.mc.debagger.DebaggerTileEntities
import de.softcoture.mc.debagger.MOD_ID
import de.softcoture.mc.debagger.tileentity.TileEntityDebaggerCloset
import net.minecraftforge.fml.common.registry.GameRegistry

object ModTileEntities {
    fun register () {
        val name = MOD_ID + ':' + DebaggerTileEntities.TILE_ENTITY_DEBAGGER_CLOSET.unlocalizedName
        GameRegistry.registerTileEntity(TileEntityDebaggerCloset::class.java, name)
    }
}