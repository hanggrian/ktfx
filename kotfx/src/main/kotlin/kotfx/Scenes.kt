@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint

/** Equivalent to Android's ViewManager. */
interface ChildManager {

    /** Shadowed when being implemented in pane. */
    fun getChildren(): ObservableList<Node>

    /** Convenient method to add child to this pane. */
    fun <N : Node> N.add(): N = apply { getChildren().add(this) }
}

inline fun Parent.toScene(): Scene = Scene(this)

@JvmOverloads
inline fun Parent.toScene(width: Double, height: Double, fill: Paint = WHITE): Scene = Scene(this, width, height, fill)

inline fun Parent.toScene(fill: Paint): Scene = Scene(this, fill)