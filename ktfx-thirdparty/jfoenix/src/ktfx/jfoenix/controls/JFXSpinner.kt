@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXSpinner
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXSpinner] to this manager. */
fun NodeManager.jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS
): JFXSpinner = JFXSpinner(progress).add()

/** Add a [JFXSpinner] with initialization block to this manager. */
inline fun NodeManager.jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS,
    init: (@LayoutDslMarker JFXSpinner).() -> Unit
): JFXSpinner = jfxSpinner(progress).apply(init)
