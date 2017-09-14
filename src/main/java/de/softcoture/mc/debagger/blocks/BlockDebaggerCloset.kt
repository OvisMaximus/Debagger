package de.softcoture.mc.debagger.blocks

import de.softcoture.mc.debagger.CreativeTab
import de.softcoture.mc.debagger.DebaggerBlocks
import net.minecraft.block.Block
import net.minecraft.block.BlockHorizontal
import net.minecraft.block.material.Material
import net.minecraft.block.properties.IProperty
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumFacing
import net.minecraft.util.Mirror
import net.minecraft.util.Rotation
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World
import java.util.*

class BlockDebaggerCloset : BlockHorizontal {
    val quantity = 1

    constructor() : super(Material.IRON) {
        unlocalizedName = DebaggerBlocks.BLOCK_DEBAGGER_CLOSET.unlocalizedName
        setRegistryName(DebaggerBlocks.BLOCK_DEBAGGER_CLOSET.registryName)

        setHarvestLevel("axe", 1)
        setHardness(10.0f)
        setResistance(10.0f)
        setCreativeTab(CreativeTab)
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    override fun getStateFromMeta(meta: Int): IBlockState {
        var enumfacing = EnumFacing.getFront(meta)

        if (enumfacing.axis == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH
        }

        return this.defaultState.withProperty(FACING, enumfacing)
    }

    override fun getMetaFromState(state: IBlockState): Int {
        return (state.getValue(FACING) as EnumFacing).index
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, *arrayOf<IProperty<*>>(FACING))
    }

    override fun onBlockPlacedBy(worldIn: World?, pos: BlockPos?, state: IBlockState?, placer: EntityLivingBase?, stack: ItemStack?) {
        val playerFacingIndex = facingIndexFromRotationYaw(placer!!.rotationYaw)
        val facing = when(playerFacingIndex) {
            1 -> EnumFacing.EAST
            2 -> EnumFacing.NORTH
            3 -> EnumFacing.WEST
            else -> EnumFacing.SOUTH
        }
        worldIn!!.setBlockState(pos,state!!.withProperty(FACING, facing))
    }

    private fun facingIndexFromRotationYaw(rotationYaw: Float) =
            MathHelper.floor_double((rotationYaw * 4.0f / 360.0f).toDouble() + 0.5) and 3

    override fun getItemDropped(state: IBlockState?, rand: Random?, fortune: Int): Item? {
        return Item.getItemFromBlock(this)
    }

    override fun quantityDropped(random: Random?): Int {
        return quantity
    }
}