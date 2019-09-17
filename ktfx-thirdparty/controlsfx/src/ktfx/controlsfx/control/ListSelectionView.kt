@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.ListSelectionView

/** Create a [ListSelectionView] with initialization block. */
inline fun <T> listSelectionView(
    init: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> = ListSelectionView<T>().apply(init)

/** Add a [ListSelectionView] to this manager. */
fun <T> NodeManager.listSelectionView(): ListSelectionView<T> =
    addNode(ktfx.controlsfx.listSelectionView { })

/** Add a [ListSelectionView] with initialization block to this manager. */
inline fun <T> NodeManager.listSelectionView(
    init: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> = addNode(ktfx.controlsfx.listSelectionView(init))