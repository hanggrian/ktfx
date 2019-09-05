@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeCell
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXTreeCell] to this manager. */
fun <T> NodeManager.jfxTreeCell(): JFXTreeCell<T> =
    JFXTreeCell<T>().add()

/** Add a [JFXTreeCell] with initialization block to this manager. */
inline fun <T> NodeManager.jfxTreeCell(
    init: (@LayoutDslMarker JFXTreeCell<T>).() -> Unit
): JFXTreeCell<T> = jfxTreeCell<T>().apply(init)
