package de.softcoture.mc.debagger


const val MOD_ID  = "smd"
const val NAME = "Debagger"
const val VERSION = "0.0.1"
const val ACCEPTED_VERSIONS = "[1.10.2]"

const val CLIENT_PROXY_CLASS = "de.softcoture.mc.debagger.proxy.ClientProxy"
const val SERVER_PROXY_CLASS = "de.softcoture.mc.debagger.proxy.ServerProxy"

enum class DebaggerItems (val unlocalizedName:String, val registryName:String) {
    RUBY("ruby", "ItemRuby"),
    OBSIDIAN_INGOT("obsidianIngot", "ItemObsidianIngot" );
}

enum class DebaggerBlocks (val unlocalizedName:String, val registryName:String) {
    BLOCK_RUBY("blockRuby", "BlockRuby"),
    BLOCK_DEBAGGER_CLOSET("blockDebaggerCloset", "BlockDebaggerCloset");
}