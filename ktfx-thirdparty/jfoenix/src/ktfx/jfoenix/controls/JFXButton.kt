@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXButton
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXButton]. */
fun jfxButton(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDslMarker JFXButton).() -> Unit)? = null
): JFXButton = JFXButton(text, graphic).also { init?.invoke(it) }

/** Creates a [JFXButton] and add it to this manager. */
inline fun NodeManager.jfxButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDslMarker JFXButton).() -> Unit)? = null
): JFXButton = ktfx.jfoenix.jfxButton(text, graphic, init).add()
