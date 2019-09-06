@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXButton
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXButton] with initialization block. */
inline fun jfxButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton = JFXButton(text, graphic).apply(init)

/** Add a [JFXButton] to this manager. */
fun NodeManager.jfxButton(
    text: String? = null,
    graphic: Node? = null
): JFXButton = addNode(ktfx.jfoenix.jfxButton(text, graphic) { })

/** Add a [JFXButton] with initialization block to this manager. */
inline fun NodeManager.jfxButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton = addNode(ktfx.jfoenix.jfxButton(text, graphic, init))
