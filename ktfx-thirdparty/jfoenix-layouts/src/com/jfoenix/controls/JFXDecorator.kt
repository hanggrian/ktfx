@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXDecorator
import javafx.scene.Node
import javafx.stage.Stage
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXDecorator] with initialization block. */
inline fun jfxDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    init: (@LayoutDslMarker JFXDecorator).() -> Unit
): JFXDecorator = JFXDecorator(stage, node, fullScreen, max, min).apply(init)

/** Add a [JFXDecorator] to this manager. */
fun NodeManager.jfxDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true
): JFXDecorator = addNode(JFXDecorator(stage, node, fullScreen, max, min))

/** Add a [JFXDecorator] with initialization block to this manager. */
inline fun NodeManager.jfxDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    init: (@LayoutDslMarker JFXDecorator).() -> Unit
): JFXDecorator = addNode(JFXDecorator(stage, node, fullScreen, max, min), init)
