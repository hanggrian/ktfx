@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXChip]. */
fun <T> jfxChip(
    view: JFXChipView<T>,
    item: T,
    init: ((@LayoutDsl JFXChip<T>).() -> Unit)? = null
): JFXChip<T> = JFXChip<T>(view, item).also {
    init?.invoke(it)
}

/** Creates a [JFXChip] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.jfxChip(
    view: JFXChipView<T>,
    item: T,
    noinline init: ((@LayoutDsl JFXChip<T>).() -> Unit)? = null
): JFXChip<T> = ktfx.jfoenix.jfxChip(view, item, init)()