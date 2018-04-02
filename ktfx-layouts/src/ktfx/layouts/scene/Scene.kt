@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.beans.property.ReadOnlyDoubleProperty
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane

interface SceneBuilder : LayoutManager<Node> {

    val x: Double

    val xProperty: ReadOnlyDoubleProperty

    val y: Double

    val yProperty: ReadOnlyDoubleProperty
}

@PublishedApi
internal class _SceneBuilder : SceneBuilder {
    private var _scene: Scene? = null
    val scene: Scene = requireNotNull(_scene) { "Invoke layout dsl first" }

    override fun <T : Node> T.add(): T = also {
        _scene = Scene(when (it) {
            is Parent -> it
            else -> Pane(it)
        })
    }

    override val x: Double get() = scene.x
    override val xProperty: ReadOnlyDoubleProperty get() = scene.xProperty()
    override val y: Double get() = scene.y
    override val yProperty: ReadOnlyDoubleProperty get() = scene.yProperty()
}

inline fun scene(
    init: SceneBuilder.() -> Unit
): Scene = _SceneBuilder().apply(init).scene