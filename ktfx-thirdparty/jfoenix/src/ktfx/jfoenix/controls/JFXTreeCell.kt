@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeCell
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXTreeCell] with initialization block. */
inline fun <T> jfxTreeCell(
    init: (@LayoutDslMarker JFXTreeCell<T>).() -> Unit
): JFXTreeCell<T> = JFXTreeCell<T>().apply(init)

/** Add a [JFXTreeCell] to this manager. */
fun <T> NodeManager.jfxTreeCell(): JFXTreeCell<T> =
    addNode(ktfx.jfoenix.jfxTreeCell { })

/** Add a [JFXTreeCell] with initialization block to this manager. */
inline fun <T> NodeManager.jfxTreeCell(
    init: (@LayoutDslMarker JFXTreeCell<T>).() -> Unit
): JFXTreeCell<T> = addNode(ktfx.jfoenix.jfxTreeCell(init))
