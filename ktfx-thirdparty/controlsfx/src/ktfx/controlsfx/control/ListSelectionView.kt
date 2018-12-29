@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker
import org.controlsfx.control.ListSelectionView

/** Creates a [ListSelectionView]. */
fun <T> listSelectionView(
    init: ((@LayoutMarker ListSelectionView<T>).() -> Unit)? = null
): ListSelectionView<T> = ListSelectionView<T>().also { init?.invoke(it) }

/** Creates a [ListSelectionView] and add it to this manager. */
inline fun <T> NodeInvokable.listSelectionView(
    noinline init: ((@LayoutMarker ListSelectionView<T>).() -> Unit)? = null
): ListSelectionView<T> = ktfx.controlsfx.listSelectionView(init)()