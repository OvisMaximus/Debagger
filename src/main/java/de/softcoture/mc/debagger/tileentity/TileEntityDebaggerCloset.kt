package de.softcoture.mc.debagger.tileentity

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.inventory.ISidedInventory
import net.minecraft.inventory.InventoryBasic
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagList
import net.minecraft.network.NetworkManager
import net.minecraft.network.play.server.SPacketUpdateTileEntity
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumFacing

class TileEntityDebaggerCloset : TileEntity(), ISidedInventory {
    private val NBT_TYPE_COMPOUND = 10
    val inventory: IInventory
    val bagInventory: IInventory
    init {
        inventory = InventoryBasic("DebaggerClosetInventoryTitle", false, 1)
        bagInventory = InventoryBasic("DebaggerClosetBagContentTitle", false, 9*6)
    }

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

    private val KEY_BAG_CONTENT = "BagContent"

    private val KEY_BAG = "Bag"

    /**
     * Load from savegame or update state of client with data from server
     */
    override fun readFromNBT(nbt: NBTTagCompound?) {
        super.readFromNBT(nbt!!)
        readInventoryFromNBT(KEY_BAG, inventory, nbt)
        readInventoryFromNBT(KEY_BAG_CONTENT, bagInventory, nbt)
    }

    /**
     * Save to savegame or prepare server data to be transferred to client
     */
    override fun writeToNBT(nbt: NBTTagCompound?): NBTTagCompound {
        super.writeToNBT(nbt!!)
        writeInventoryToNBT(KEY_BAG_CONTENT, bagInventory, nbt)
        writeInventoryToNBT(KEY_BAG, inventory, nbt)
        return nbt
    }

    private fun readInventoryFromNBT(name: String, inventoryToBeRead: IInventory, nbt: NBTTagCompound) {
        val list = nbt.getTagList(name, NBT_TYPE_COMPOUND)
        inventoryToBeRead.clear()
        for (tagIndex in 0..(list.tagCount()-1)) {
            val tag = list.getCompoundTagAt(tagIndex)
            val slotIndex = tag.getByte("Slot").toInt()
            if(slotIndex >= 0 && slotIndex < inventoryToBeRead.sizeInventory) {
                val stack = ItemStack.loadItemStackFromNBT(tag)
                inventoryToBeRead.setInventorySlotContents(slotIndex, stack)
            }
        }
        nbt.setTag(name, list)
    }

    private fun writeInventoryToNBT(name:String, inventoryToBeSaved:IInventory, nbt: NBTTagCompound) {
        val list = NBTTagList()
        for (slotIndex in 0..(inventoryToBeSaved.sizeInventory-1)) {
            val tag = NBTTagCompound()
            tag.setByte("Slot", slotIndex.toByte())
            inventoryToBeSaved.getStackInSlot(slotIndex)?.writeToNBT(tag)
            list.appendTag(tag)
        }
        nbt.setTag(name, list)
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