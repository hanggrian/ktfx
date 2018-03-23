package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.Menu

/**
 * LayoutManager for adding menus with Kotlin DSL.
 *
 * @see _Menu
 */
interface MenuLayoutManager : LayoutManager<Menu> {

    /** Shall be shadowed on classes extending this interface. */
    fun getMenus(): ObservableList<Menu>

    override fun <T : Menu> T.add(): T = also { getMenus() += it }
}