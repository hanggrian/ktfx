@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDecorator
import javafx.scene.Node
import javafx.stage.Stage
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXDecorator] with initialization block. */
inline fun jfxDecorator(
    stage: Stage,
    node: Node,
    fullscreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    init: (@LayoutDslMarker JFXDecorator).() -> Unit
): JFXDecorator = JFXDecorator(stage, node, fullscreen, max, min).apply(init)

/** Add a [JFXDecorator] to this manager. */
fun NodeManager.jfxDecorator(
    stage: Stage,
    node: Node,
    fullscreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true
): JFXDecorator = addNode(ktfx.jfoenix.jfxDecorator(stage, node, fullscreen, max, min) { })

/** Add a [JFXDecorator] with initialization block to this manager. */
inline fun NodeManager.jfxDecorator(
    stage: Stage,
    node: Node,
    fullscreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    init: (@LayoutDslMarker JFXDecorator).() -> Unit
): JFXDecorator = addNode(ktfx.jfoenix.jfxDecorator(stage, node, fullscreen, max, min, init))
