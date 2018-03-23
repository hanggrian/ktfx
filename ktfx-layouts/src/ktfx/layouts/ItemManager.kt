package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node

/**
 * Manager for adding items with Kotlin DSL.
 */
interface ItemManager : Manager<Node> {

    /** Shall be shadowed on classes extending this interface. */
    fun getItems(): ObservableList<Node>

    override fun <T : Node> T.add(): T = also { getItems() += it }
}