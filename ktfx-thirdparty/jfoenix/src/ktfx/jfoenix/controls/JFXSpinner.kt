@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXSpinner
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXSpinner]. */
fun jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS,
    init: ((@LayoutDslMarker JFXSpinner).() -> Unit)? = null
): JFXSpinner = JFXSpinner(progress).also { init?.invoke(it) }

/** Creates a [JFXSpinner] and add it to this manager. */
inline fun NodeManager.jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDslMarker JFXSpinner).() -> Unit)? = null
): JFXSpinner = ktfx.jfoenix.jfxSpinner(progress, init).add()
