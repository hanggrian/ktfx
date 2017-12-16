package kotfx.internal

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem

interface ChildManager {

    /** Shadowed when being implemented in [javafx.scene.layout.Pane]. */
    fun getChildren(): ObservableList<Node>

    /** Convenient method to add child to this [javafx.scene.layout.Pane]. */
    fun <T : Node> T.add(): T = apply { getChildren().add(this) }
}

interface ItemManager {

    /** Shadowed when being implemented in [javafx.scene.control.ToolBar]. */
    fun getItems(): ObservableList<Node>

    /** Convenient method to add child to this [javafx.scene.control.ToolBar]. */
    fun <T : Node> T.add(): T = apply { getItems().add(this) }
}

interface MenuManager {

    /** Shadowed when being implemented in [javafx.scene.control.MenuBar]. */
    fun getMenus(): ObservableList<Menu>

    /** Convenient method to add child to this [javafx.scene.control.MenuBar]. */
    fun <T : Menu> T.add(): T = apply { getMenus().add(this) }
}

interface PopupManager {

    /** Shadowed when being implemented in [javafx.scene.control.ContextMenu]. */
    fun getItems(): ObservableList<MenuItem>

    /** Convenient method to add child to this [javafx.scene.control.ContextMenu]. */
    fun <T : MenuItem> T.add(): T = apply { getItems().add(this) }
}