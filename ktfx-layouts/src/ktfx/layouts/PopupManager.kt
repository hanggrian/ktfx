package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.MenuItem

/**
 * Manager for adding menu items with Kotlin DSL.
 */
interface PopupManager : Manager<MenuItem> {

    /** Shall be shadowed on classes extending this interface. */
    fun getItems(): ObservableList<MenuItem>

    override fun <T : MenuItem> T.add(): T = also { getItems() += it }
}