package kotfx.controls

import javafx.collections.ObservableList
import javafx.scene.control.Menu

interface MenuManager {

    /** Shadowed when being implemented in [javafx.scene.control.MenuBar]. */
    fun getMenus(): ObservableList<Menu>

    /** Convenient method to add child to this [javafx.scene.control.MenuBar]. */
    fun <T : Menu> T.add(): T = apply { getMenus().add(this) }
}