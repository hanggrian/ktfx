@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDecorator
import javafx.scene.Node
import javafx.stage.Stage
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutDslMarker

/** Creates a [JFXDecorator]. */
fun jfxDecorator(
    stage: Stage,
    node: Node,
    fullscreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    init: ((@LayoutDslMarker JFXDecorator).() -> Unit)? = null
): JFXDecorator = JFXDecorator(stage, node, fullscreen, max, min).also { init?.invoke(it) }

/** Creates a [JFXDecorator] and add it to this manager. */
inline fun NodeManager.jfxDecorator(
    stage: Stage,
    node: Node,
    fullscreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    noinline init: ((@LayoutDslMarker JFXDecorator).() -> Unit)? = null
): JFXDecorator = ktfx.jfoenix.jfxDecorator(stage, node, fullscreen, max, min, init).add()