@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.geometry.Bounds
import javafx.scene.Node
import javafx.scene.control.ScrollPane
import kotfx._Pane
import kotfx.internal.ControlDsl

class _ScrollPane(content: Node?) : ScrollPane(content), _Control<ScrollPane> {
    override val node: ScrollPane get() = this

    fun hbarPolicy(value: ScrollBarPolicy) = setHbarPolicy(value)
    fun vbarPolicy(value: ScrollBarPolicy) = setVbarPolicy(value)
    fun content(value: Node) = setContent(value)
    fun hvalue(value: Number) = setHvalue(value.toDouble())
    fun vvalue(value: Number) = setVvalue(value.toDouble())
    fun hmin(value: Number) = setHmin(value.toDouble())
    fun vmin(value: Number) = setVmin(value.toDouble())
    fun hmax(value: Number) = setHmax(value.toDouble())
    fun vmax(value: Number) = setVmax(value.toDouble())
    fun fitToWidth(value: Boolean) = setFitToWidth(value)
    fun fitToHeight(value: Boolean) = setFitToHeight(value)
    fun pannable(value: Boolean) = setPannable(value)
    fun prefViewportWidth(value: Number) = setPrefViewportWidth(value.toDouble())
    fun prefViewportHeight(value: Number) = setPrefViewportHeight(value.toDouble())
    fun minViewportWidth(value: Number) = setMinViewportWidth(value.toDouble())
    fun minViewportHeight(value: Number) = setMinViewportHeight(value.toDouble())
    fun viewportBounds(value: Bounds) = setViewportBounds(value)
}

@JvmOverloads
inline fun scrollPaneOf(
        content: Node? = null,
        noinline init: ((@ControlDsl _ScrollPane).() -> Unit)? = null
): ScrollPane = _ScrollPane(content).apply { if (init != null) init() }

@JvmOverloads
inline fun _Pane.scrollPane(
        content: Node? = null,
        noinline init: ((@ControlDsl _ScrollPane).() -> Unit)? = null
): ScrollPane = scrollPaneOf(content, init).add()