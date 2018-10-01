@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXPopup
import javafx.scene.layout.Region
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

open class _JFXPopup(content: Region? = null) : JFXPopup(content), LayoutManager<Region> {

    override fun <T : Region> T.invoke(): T = also { popupContent = it }
}

/** Creates a [JFXPopup]. */
fun jfxPopup(
    content: Region? = null,
    init: ((@LayoutDsl _JFXPopup).() -> Unit)? = null
): JFXPopup = _JFXPopup(content).also {
    init?.invoke(it)
}