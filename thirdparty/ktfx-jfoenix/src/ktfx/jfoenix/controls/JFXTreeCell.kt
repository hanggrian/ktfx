@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeCell
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [JFXTreeCell]. */
fun <T> jfxTreeCell(
    init: ((@LayoutDsl JFXTreeCell<T>).() -> Unit)? = null
): JFXTreeCell<T> = JFXTreeCell<T>().also { init?.invoke(it) }

/** Creates a [JFXTreeCell] and add it to this manager. */
inline fun <T> NodeInvokable.jfxTreeCell(
    noinline init: ((@LayoutDsl JFXTreeCell<T>).() -> Unit)? = null
): JFXTreeCell<T> = ktfx.jfoenix.jfxTreeCell(init)()