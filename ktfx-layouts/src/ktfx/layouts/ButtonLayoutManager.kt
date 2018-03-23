package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node

/**
 * LayoutManager for adding buttons with Kotlin DSL.
 *
 * @see _ButtonBar
 */
interface ButtonLayoutManager : LayoutManager<Node> {

    /** Shall be shadowed on classes extending this interface. */
    fun getButtons(): ObservableList<Node>

    override fun <T : Node> T.add(): T = also { getButtons() += it }
}