package kotfx

import javafx.collections.ObservableList
import javafx.scene.Node

interface ChildManager {

    /** Shadowed when being implemented in [javafx.scene.layout.Pane]. */
    fun getChildren(): ObservableList<Node>

    /** Convenient method to add child to this [javafx.scene.layout.Pane]. */
    fun <T : Node> T.add(): T = apply { getChildren().add(this) }
}