@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.NodeManager
import ktfx.LayoutDsl
import org.controlsfx.control.ListSelectionView

/** Creates a [ListSelectionView]. */
fun <T> listSelectionView(
    init: ((@LayoutDsl ListSelectionView<T>).() -> Unit)? = null
): ListSelectionView<T> = ListSelectionView<T>().also { init?.invoke(it) }

/** Creates a [ListSelectionView] and add it to this manager. */
inline fun <T> NodeManager.listSelectionView(
    noinline init: ((@LayoutDsl ListSelectionView<T>).() -> Unit)? = null
): ListSelectionView<T> = ktfx.controlsfx.listSelectionView(init)()