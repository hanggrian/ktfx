@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXChipView
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXChipView]. */
fun <T> jfxChipView(
    init: ((@LayoutDsl JFXChipView<T>).() -> Unit)? = null
): JFXChipView<T> = JFXChipView<T>().also { init?.invoke(it) }

/** Creates a [JFXChipView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.jfxChipView(
    noinline init: ((@LayoutDsl JFXChipView<T>).() -> Unit)? = null
): JFXChipView<T> = ktfx.jfoenix.jfxChipView(init)()