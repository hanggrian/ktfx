@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")

package ktfx.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.ListSelectionView

/** Create a [ListSelectionView] with initialization block. */
inline fun <T> listSelectionView(
    init: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> = ListSelectionView<T>().apply(init)

/** Add a [ListSelectionView] to this manager. */
fun <T> NodeManager.listSelectionView(): ListSelectionView<T> =
    addNode(ListSelectionView())

/** Add a [ListSelectionView] with initialization block to this manager. */
inline fun <T> NodeManager.listSelectionView(
    init: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> = addNode(ListSelectionView(), init)
