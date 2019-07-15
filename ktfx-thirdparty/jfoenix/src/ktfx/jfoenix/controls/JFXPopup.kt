@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXPopup
import javafx.scene.Node
import ktfx.internal.KtfxInternals
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

open class _JFXPopup : JFXPopup(), NodeManager {

    override fun <T : Node> T.add(): T = also { popupContent = KtfxInternals.asPane(it) }
}

/** Creates a [JFXPopup]. */
fun jfxPopup(
    init: ((@LayoutDslMarker _JFXPopup).() -> Unit)? = null
): JFXPopup = _JFXPopup().also { init?.invoke(it) }
