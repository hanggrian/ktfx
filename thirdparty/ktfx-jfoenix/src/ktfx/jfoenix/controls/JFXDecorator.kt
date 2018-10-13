@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXDecorator
import javafx.scene.Node
import javafx.stage.Stage
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXDecorator]. */
fun jfxDecorator(
    stage: Stage,
    node: Node,
    fullscreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    init: ((@LayoutDsl JFXDecorator).() -> Unit)? = null
): JFXDecorator = JFXDecorator(stage, node, fullscreen, max, min).also { init?.invoke(it) }

/** Creates a [JFXDecorator] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxDecorator(
    stage: Stage,
    node: Node,
    fullscreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    noinline init: ((@LayoutDsl JFXDecorator).() -> Unit)? = null
): JFXDecorator = ktfx.jfoenix.jfxDecorator(stage, node, fullscreen, max, min, init)()