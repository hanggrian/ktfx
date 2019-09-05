@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXButton
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXButton] to this manager. */
fun NodeManager.jfxButton(
    text: String? = null,
    graphic: Node? = null
): JFXButton = JFXButton(text, graphic).add()

/** Add a [JFXButton] with initialization block to this manager. */
inline fun NodeManager.jfxButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton = jfxButton(text, graphic).apply(init)
