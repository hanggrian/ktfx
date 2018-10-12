@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXListCell
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXListCell]. */
fun <T> jfxListCell(
    init: ((@LayoutDsl JFXListCell<T>).() -> Unit)? = null
): JFXListCell<T> = JFXListCell<T>().also { init?.invoke(it) }

/** Creates a [JFXListCell] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.jfxListCell(
    noinline init: ((@LayoutDsl JFXListCell<T>).() -> Unit)? = null
): JFXListCell<T> = ktfx.jfoenix.jfxListCell(init)()