@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXTreeCell
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXTreeCell]. */
fun <T> jfxTreeCell(
    init: ((@LayoutDsl JFXTreeCell<T>).() -> Unit)? = null
): JFXTreeCell<T> = JFXTreeCell<T>().also { init?.invoke(it) }

/** Creates a [JFXTreeCell] and add it to this manager. */
inline fun <T> NodeManager.jfxTreeCell(
    noinline init: ((@LayoutDsl JFXTreeCell<T>).() -> Unit)? = null
): JFXTreeCell<T> = ktfx.jfoenix.jfxTreeCell(init)()