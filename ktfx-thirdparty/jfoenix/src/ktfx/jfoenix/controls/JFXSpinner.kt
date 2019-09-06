@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXSpinner
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXSpinner] with initialization block to this manager. */
inline fun jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS,
    init: (@LayoutDslMarker JFXSpinner).() -> Unit
): JFXSpinner = JFXSpinner(progress).apply(init)

/** Add a [JFXSpinner] to this manager. */
fun NodeManager.jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS
): JFXSpinner = addNode(ktfx.jfoenix.jfxSpinner(progress) { })

/** Add a [JFXSpinner] with initialization block to this manager. */
inline fun NodeManager.jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS,
    init: (@LayoutDslMarker JFXSpinner).() -> Unit
): JFXSpinner = addNode(ktfx.jfoenix.jfxSpinner(progress, init))
