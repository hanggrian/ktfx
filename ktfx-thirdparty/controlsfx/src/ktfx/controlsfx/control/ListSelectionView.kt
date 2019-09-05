@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.ListSelectionView

/** Add a [ListSelectionView] to this manager. */
fun <T> NodeManager.listSelectionView(): ListSelectionView<T> =
    ListSelectionView<T>().add()

/** Add a [ListSelectionView] with initialization block to this manager. */
inline fun <T> NodeManager.listSelectionView(
    init: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> = listSelectionView<T>().apply(init)
