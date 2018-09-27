@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXSpinner
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXSpinner]. */
fun jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS,
    init: ((@LayoutDsl JFXSpinner).() -> Unit)? = null
): JFXSpinner = JFXSpinner(progress).also {
    init?.invoke(it)
}

/** Creates a [JFXSpinner] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl JFXSpinner).() -> Unit)? = null
): JFXSpinner = ktfx.jfoenix.jfxSpinner(progress, init)()