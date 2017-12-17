package kotfx.controls

import javafx.collections.ObservableList
import javafx.scene.Node

interface ItemManager {

    /** Shadowed when being implemented in [javafx.scene.control.ToolBar]. */
    fun getItems(): ObservableList<Node>

    /** Convenient method to add child to this [javafx.scene.control.ToolBar]. */
    fun <T : Node> T.add(): T = apply { getItems().add(this) }
}