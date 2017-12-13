package kotfx.internal

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.layout.Pane
import kotfx.controls._Region

/** Equivalent to Android's ViewManager. */
interface ChildManager : _Region<Pane> {

    /** Shadowed when being implemented in [javafx.scene.layout.Pane] */
    fun getChildren(): ObservableList<Node>

    fun <T : Node> T.add(): T = apply { getChildren().add(this) }

    fun <T : Node> T.clearConstraints(): T
}