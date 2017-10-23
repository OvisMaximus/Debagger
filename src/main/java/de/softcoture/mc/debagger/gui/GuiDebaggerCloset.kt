package de.softcoture.mc.debagger.gui

import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.inventory.Container
import net.minecraft.util.ResourceLocation

val BACKGROUND = ResourceLocation("smd:textures/gui/debagger_closet.png")

enum class SlotGroupProperties(val numRows: Int, val numColumns: Int, val xOffset: Int, val yOffset: Int){
    BAG(1, 1, 80, 8),
    BAG_INVENTORY(5, 9, 8, 52),
    PLAYER_INVENTORY(3, 9, 8, 156),
    PLAYER_HOTBAR(1, 9, 8, 214);

    fun numSlots(): Int = numRows * numColumns
}

class GuiDebaggerCloset (container: Container)  : GuiContainer(container) {
    init {
        xSize = 176
        ySize = 238
    }

    override fun drawGuiContainerBackgroundLayer(partialTicks: Float, mouseX: Int, mouseY: Int) {
        mc.renderEngine.bindTexture(BACKGROUND)

        drawBackgroundToScreenCenter()
    }

    private fun drawBackgroundToScreenCenter() {
        // height and width are set to screen resolution
        val xPos = (width - xSize) / 2
        val yPos = (height - ySize) / 2

        drawTexturedModalRect(xPos, yPos, 0, 0, xSize, ySize)
    }


}
