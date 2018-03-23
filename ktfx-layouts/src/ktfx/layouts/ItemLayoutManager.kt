package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node

/**
 * LayoutManager for adding items with Kotlin DSL.
 *
 * @see _ToolBar
 */
interface ItemLayoutManager : LayoutManager<Node> {

    /** Shall be shadowed on classes extending this interface. */
    fun getItems(): ObservableList<Node>

    override fun <T : Node> T.add(): T = also { getItems() += it }
}