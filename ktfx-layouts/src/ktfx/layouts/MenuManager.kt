package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.Menu

/**
 * Manager for adding menus with Kotlin DSL.
 */
interface MenuManager : Manager<Menu> {

    /** Shall be shadowed on classes extending this interface. */
    fun getMenus(): ObservableList<Menu>

    override fun <T : Menu> T.add(): T = also { getMenus() += it }
}