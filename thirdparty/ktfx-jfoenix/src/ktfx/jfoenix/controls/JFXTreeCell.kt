@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXTreeCell
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXTreeCell]. */
fun <T> jfxTreeCell(
    init: ((@LayoutDsl JFXTreeCell<T>).() -> Unit)? = null
): JFXTreeCell<T> = JFXTreeCell<T>().also { init?.invoke(it) }

/** Creates a [JFXTreeCell] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.jfxTreeCell(
    noinline init: ((@LayoutDsl JFXTreeCell<T>).() -> Unit)? = null
): JFXTreeCell<T> = ktfx.jfoenix.jfxTreeCell(init)()