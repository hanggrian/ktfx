@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint

open class _Scene(
    root: Parent,
    width: Double,
    height: Double,
    fill: Paint
) : Scene(root, width, height, fill), LayoutManager<Node> {

    override fun <T : Node> T.add(): T = also {
        root = when (it) {
            is Parent -> it
            else -> Pane(it)
        }
    }
}

inline fun scene(
    root: Parent = region(),
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = WHITE
): Scene = scene(root, width, height, fill) { }

inline fun scene(
    root: Parent = region(),
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = WHITE,
    init: _Scene.() -> Unit
): Scene = _Scene(root, width, height, fill).apply(init)