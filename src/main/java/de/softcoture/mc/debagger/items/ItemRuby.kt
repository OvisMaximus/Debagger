package de.softcoture.mc.debagger.items

import de.softcoture.mc.debagger.CreativeTab
import de.softcoture.mc.debagger.DebaggerItems
import net.minecraft.item.Item

class ItemRuby : Item {
    constructor() {
        unlocalizedName = DebaggerItems.RUBY.unlocalizedName
        setRegistryName(DebaggerItems.RUBY.registryName)
        setCreativeTab(CreativeTab)
    }
}