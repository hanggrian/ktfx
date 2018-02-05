@file:Suppress("NOTHING_TO_INLINE")

package kotfx.scene

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.SceneAntialiasing
import javafx.scene.SceneAntialiasing.DISABLED
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint
import javafx.util.Builder
import kotfx.collections.mutableObservableListOf
import kotfx.internal.NO_GETTER
import kotfx.internal.noGetter
import kotlin.DeprecationLevel.ERROR

interface SceneBuilder : Builder<Scene>, ChildRoot {
    var width: Number
    var height: Number
    var fill: Paint
    var depthBuffer: Boolean
    var antiAliasing: SceneAntialiasing
}

@PublishedApi
internal class _SceneBuilder : SceneBuilder {
    private val _children: ObservableList<Node> = mutableObservableListOf()
    private var _width: Number = -1
    private var _height: Number = -1
    private var _fill: Paint = WHITE
    private var _depthBuffer: Boolean = false
    private var _antiAliasing: SceneAntialiasing = DISABLED

    override fun getChildren(): ObservableList<Node> = throw UnsupportedOperationException()

    override fun <T : Node> T.add(): T {
        require(this is Parent) { "Scene DSL must be a layout" }
        return apply { _children.add(this) }
    }

    override var width: Number
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            _width = value
        }

    override var height: Number
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            _height = value
        }

    override var fill: Paint
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            _fill = value
        }

    override var depthBuffer: Boolean
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            _depthBuffer = value
        }

    override var antiAliasing: SceneAntialiasing
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            _antiAliasing = value
        }

    override fun build(): Scene {
        require(_children.size == 1) { "Scene must have exactly 1 scene DSL as root" }
        return Scene(_children[0] as Parent, _width.toDouble(), _height.toDouble(), _depthBuffer, _antiAliasing)
    }
}

inline fun scene(init: SceneBuilder.() -> Unit): Scene = _SceneBuilder().apply(init).build()