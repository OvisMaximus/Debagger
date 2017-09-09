package de.softcoture.mc.debagger.blocks

import de.softcoture.mc.debagger.CreativeTab
import de.softcoture.mc.debagger.DebaggerBlocks
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.item.Item
import java.util.*

class BlockDebaggerCloset : Block {
    val quantity = 1

    constructor() : super(Material.IRON) {
        unlocalizedName = DebaggerBlocks.BLOCK_DEBAGGER_CLOSET.unlocalizedName
        setRegistryName(DebaggerBlocks.BLOCK_DEBAGGER_CLOSET.registryName)

        setHarvestLevel("axe", 1)
        setHardness(10.0f)
        setResistance(10.0f)
        setCreativeTab(CreativeTab)
    }

    override fun getItemDropped(state: IBlockState?, rand: Random?, fortune: Int): Item? {
        return Item.getItemFromBlock(this)
    }

    override fun quantityDropped(random: Random?): Int {
        return quantity
    }
}