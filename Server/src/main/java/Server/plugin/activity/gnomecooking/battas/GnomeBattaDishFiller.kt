package plugin.activity.gnomecooking.battas

import core.game.content.ItemNames
import core.game.interaction.NodeUsageEvent
import core.game.interaction.UseWithHandler
import core.game.node.item.Item
import core.plugin.InitializablePlugin
import core.plugin.Plugin

private const val GIANNE_DOUGH = 2171
private const val BATTA_MOULD = 2164
private const val RAW_CRUNCHIES = 2202

/**
 * Fills gnome batta dishes
 * @author Ceikry
 */
@InitializablePlugin
class GnomeBattaDishFiller : UseWithHandler(GIANNE_DOUGH) {
    override fun newInstance(arg: Any?): Plugin<Any> {
        addHandler(BATTA_MOULD, ITEM_TYPE,this)
        return this
    }

    override fun handle(event: NodeUsageEvent?): Boolean {
        event ?: return false
        val player = event.player
        val used = event.used
        val with = event.usedWith
        player.inventory.remove(used.asItem())
        player.inventory.remove(with.asItem())
        player.inventory.add(Item(ItemNames.RAW_BATTA_2250))
        return true
    }

}