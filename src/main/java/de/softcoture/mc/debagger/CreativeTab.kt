package de.softcoture.mc.debagger

import de.softcoture.mc.debagger.init.ModItems.RUBY
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@SideOnly(Side.CLIENT)
object CreativeTab : CreativeTabs("tab_debagger") {
    override fun getTabIconItem(): Item {
        return RUBY
    }
}
