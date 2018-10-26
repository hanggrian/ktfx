@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXPopup
import javafx.scene.Node
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import ktfx.internal.KtfxInternals

open class _JFXPopup : JFXPopup(), NodeManager by NodeManager.invokableOnly() {

    override fun <T : Node> T.invoke(): T = also { popupContent = KtfxInternals.asPane(it) }
}

/** Creates a [JFXPopup]. */
fun jfxPopup(
    init: ((@LayoutDsl _JFXPopup).() -> Unit)? = null
): JFXPopup = _JFXPopup().also { init?.invoke(it) }