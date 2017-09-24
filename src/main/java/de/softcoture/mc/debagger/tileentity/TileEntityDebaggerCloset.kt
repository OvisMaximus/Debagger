package de.softcoture.mc.debagger.tileentity

import de.softcoture.mc.debagger.DebaggerBlocks
import de.softcoture.mc.debagger.DebaggerTileEntities
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.ISidedInventory
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.network.NetworkManager
import net.minecraft.network.play.server.SPacketUpdateTileEntity
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumFacing

class TileEntityDebaggerCloset : TileEntity(), ISidedInventory {

    override fun getField(id: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasCustomName(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStackInSlot(index: Int): ItemStack? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun decrStackSize(index: Int, count: Int): ItemStack? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSizeInventory(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isItemValidForSlot(index: Int, stack: ItemStack?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInventoryStackLimit(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun canInsertItem(index: Int, itemStackIn: ItemStack?, direction: EnumFacing?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSlotsForFace(side: EnumFacing?): IntArray {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isUseableByPlayer(player: EntityPlayer?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun canExtractItem(index: Int, stack: ItemStack?, direction: EnumFacing?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openInventory(player: EntityPlayer?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setField(id: Int, value: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun closeInventory(player: EntityPlayer?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setInventorySlotContents(index: Int, stack: ItemStack?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeStackFromSlot(index: Int): ItemStack? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFieldCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Load from savegame or update state of client with data from server
     */
    override fun readFromNBT(nbt: NBTTagCompound?) {
        super.readFromNBT(nbt)
    }

    /**
     * Save to savegame or prepare server data to be transferred to client
     */
    override fun writeToNBT(nbt: NBTTagCompound?): NBTTagCompound {
        return super.writeToNBT(nbt)
    }

    /**
     * get current data from server instance to update clients
     */
    override fun getUpdatePacket(): SPacketUpdateTileEntity? {
        return super.getUpdatePacket()
    }

    /**
     * update client with data received from server
     */
    override fun onDataPacket(net: NetworkManager?, pkt: SPacketUpdateTileEntity?) {
        super.onDataPacket(net, pkt)
    }

    /**
     * get current Data from Server on Chunk loading
     */
    override fun getUpdateTag(): NBTTagCompound {
        return super.getUpdateTag()
    }

    /**
     * update client with data from server on chunk loading
     */
    override fun handleUpdateTag(tag: NBTTagCompound?) {
        super.handleUpdateTag(tag)
    }
}