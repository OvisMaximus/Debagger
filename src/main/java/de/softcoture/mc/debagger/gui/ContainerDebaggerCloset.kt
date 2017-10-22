package de.softcoture.mc.debagger.gui

import de.softcoture.mc.debagger.tileentity.TileEntityDebaggerCloset
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.Container
import net.minecraft.item.ItemStack
import net.minecraft.inventory.IInventory
import net.minecraft.inventory.Slot

const val GUI_SLOT_PIXEL_SIZE = 18

class ContainerDebaggerCloset(playerInv: IInventory, debaggerCloset: TileEntityDebaggerCloset): Container() {

    private val indexOfBagInventory = SlotGroupProperties.BAG.numSlots()
    private val indexOfPlayerInventory = indexOfBagInventory + SlotGroupProperties.BAG_INVENTORY.numSlots()

    init  {
        addInventorySlots(debaggerCloset.inventory, 0, SlotGroupProperties.BAG)
        addInventorySlots(debaggerCloset.bagInventory, 0, SlotGroupProperties.BAG_INVENTORY)
        addInventorySlots(playerInv, SlotGroupProperties.PLAYER_HOTBAR.numSlots(), SlotGroupProperties.PLAYER_INVENTORY)
        addInventorySlots(playerInv, 0, SlotGroupProperties.PLAYER_HOTBAR)
    }

    private fun addInventorySlots(inventory: IInventory, startIndex: Int, group: SlotGroupProperties) {
        var index = startIndex
        for (row in 0..(group.numRows-1)) {
            for (column in 0..(group.numColumns-1)) {
                if (inventory.sizeInventory <= index) break
                val xPosition = group.xOffset + column * GUI_SLOT_PIXEL_SIZE
                val yPosition = group.yOffset + row * GUI_SLOT_PIXEL_SIZE
                addSlotToContainer(Slot(inventory, index++, xPosition, yPosition))
            }
        }
    }

    override fun canInteractWith(playerIn: EntityPlayer?): Boolean {
        //should switch to false if distance of player and closet increases due to external impact on player
        return true
    }

    override fun transferStackInSlot(playerIn: EntityPlayer?, index: Int): ItemStack? {
        var itemStack: ItemStack? = null
        val slot = this.inventorySlots[index] as Slot
// real implementation with bag TBD
        if (slot.hasStack) {
            val clickedStack = slot.stack!!
            itemStack = clickedStack.copy()

            if (index < indexOfPlayerInventory) {
                if (!this.mergeItemStack(clickedStack, indexOfPlayerInventory, this.inventorySlots.size, true)) {
                    return null
                }
            } else if (!this.mergeItemStack(clickedStack, 0, indexOfPlayerInventory, false)) {
                return null
            }

            if (clickedStack.stackSize == 0) {
                slot.putStack(null as ItemStack?)
            } else {
                slot.onSlotChanged()
            }
        }

        return itemStack
    }

}