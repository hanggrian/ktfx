package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.MenuItem

/**
 * LayoutManager for adding menu items with Kotlin DSL.
 *
 * @see _ContextMenu
 * @see _Menu
 */
interface PopupLayoutManager : LayoutManager<MenuItem> {

    /** Shall be shadowed on classes extending this interface. */
    fun getItems(): ObservableList<MenuItem>

    override fun <T : MenuItem> T.add(): T = also { getItems() += it }
}