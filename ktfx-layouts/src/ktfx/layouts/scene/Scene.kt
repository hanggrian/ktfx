@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.layout.Region

open class _Scene : Scene(Region()), LayoutManager<Node> {

    override fun <T : Node> T.add(): T = also {
        root = when (it) {
            is Parent -> it
            else -> Pane(it)
        }
    }
}

inline fun scene(
    init: _Scene.() -> Unit
): Scene = _Scene().apply(init)