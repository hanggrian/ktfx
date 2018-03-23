package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.Menu

interface MenuManager {

    fun getMenus(): ObservableList<Menu>

    fun <T : Menu> T.add(): T = also { getMenus() += it }
}