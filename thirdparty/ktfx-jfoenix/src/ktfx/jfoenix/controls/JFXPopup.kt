@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXPopup
import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.scene.layout.Region
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _JFXPopup(content: Region? = null) : JFXPopup(content), NodeManager by NodeManager.InvokableOnly {

    override fun <T : Node> T.invoke(): T = also { popupContent = it as? Region ?: Pane(it) }
}

/** Creates a [JFXPopup]. */
fun jfxPopup(
    content: Region? = null,
    init: ((@LayoutDsl _JFXPopup).() -> Unit)? = null
): JFXPopup = _JFXPopup(content).also { init?.invoke(it) }