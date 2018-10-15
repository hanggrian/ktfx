@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXPopup
import javafx.scene.Node
import javafx.scene.layout.Region
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import ktfx.internal.KtfxInternals

open class _JFXPopup(content: Region?) : JFXPopup(content), NodeManager by NodeManager.INVOKABLE_ONLY {

    override fun <T : Node> T.invoke(): T = also { popupContent = KtfxInternals.asRegion(it) }
}

/** Creates a [JFXPopup]. */
fun jfxPopup(
    content: Region? = null,
    init: ((@LayoutDsl _JFXPopup).() -> Unit)? = null
): JFXPopup = _JFXPopup(content).also { init?.invoke(it) }