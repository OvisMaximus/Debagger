package de.softcoture.mc.debagger.blocks

import de.softcoture.mc.debagger.CreativeTab
import de.softcoture.mc.debagger.DebaggerBlocks
import net.minecraft.block.Block
import net.minecraft.block.material.Material

class BlockRuby : Block {
    constructor() : super(Material.IRON) {
        unlocalizedName = DebaggerBlocks.BLOCK_RUBY.unlocalizedName
        setRegistryName(DebaggerBlocks.BLOCK_RUBY.registryName)
        setCreativeTab(CreativeTab)
    }
}