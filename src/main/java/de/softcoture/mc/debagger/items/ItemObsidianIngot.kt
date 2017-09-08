package de.softcoture.mc.debagger.items

import de.softcoture.mc.debagger.DebaggerItems
import net.minecraft.item.Item

class ItemObsidianIngot : Item {
    constructor() {
        unlocalizedName = DebaggerItems.OBSIDIAN_INGOT.unlocalizedName
        setRegistryName(DebaggerItems.OBSIDIAN_INGOT.registryName)
    }
}