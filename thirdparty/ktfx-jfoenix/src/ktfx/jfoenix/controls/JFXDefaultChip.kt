@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXDefaultChip]. */
fun <T> jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    init: ((@LayoutDsl JFXDefaultChip<T>).() -> Unit)? = null
): JFXDefaultChip<T> = JFXDefaultChip<T>(view, item).also { init?.invoke(it) }

/** Creates a [JFXDefaultChip] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    noinline init: ((@LayoutDsl JFXDefaultChip<T>).() -> Unit)? = null
): JFXDefaultChip<T> = ktfx.jfoenix.jfxDefaultChip(view, item, init)()