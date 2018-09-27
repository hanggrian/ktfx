@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.ListSelectionView

/** Creates a [ListSelectionView]. */
fun <T> listSelectionView(
    init: ((@LayoutDsl ListSelectionView<T>).() -> Unit)? = null
): ListSelectionView<T> = ListSelectionView<T>().also {
    init?.invoke(it)
}

/** Creates a [ListSelectionView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.listSelectionView(
    noinline init: ((@LayoutDsl ListSelectionView<T>).() -> Unit)? = null
): ListSelectionView<T> = ktfx.controlsfx.listSelectionView(init)()