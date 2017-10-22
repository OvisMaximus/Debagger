package de.softcoture.mc.debagger.gui

import de.softcoture.mc.debagger.DebaggerGuis
import de.softcoture.mc.debagger.tileentity.TileEntityDebaggerCloset
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.IGuiHandler

class GuiHandler : IGuiHandler{
    override fun getClientGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
        when (ID) {
            DebaggerGuis.GUI_DEBAGGER_CLOSET.id -> return GuiDebaggerCloset(createDebaggerContainer(world, x, y, z, player))
        }
        return null
    }

    override fun getServerGuiElement(ID: Int, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int): Any? {
        when (ID) {
            DebaggerGuis.GUI_DEBAGGER_CLOSET.id -> return createDebaggerContainer(world, x, y, z, player)
        }
        return null
    }

    private fun createDebaggerContainer(world: World?, x: Int, y: Int, z: Int, player: EntityPlayer?): ContainerDebaggerCloset {
        val tileEntity = world!!.getTileEntity(BlockPos(x, y, z)) as TileEntityDebaggerCloset
        val container = ContainerDebaggerCloset(player!!.inventory, tileEntity)
        return container
    }

}
