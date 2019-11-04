@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.ListSelectionView

/** Create a [ListSelectionView] with initialization block. */
inline fun <T> listSelectionView(
    init: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return ListSelectionView<T>().apply(init)
}
/** Add a [ListSelectionView] to this manager. */
fun <T> NodeManager.listSelectionView(): ListSelectionView<T> =
    addNode(ListSelectionView())

/** Add a [ListSelectionView] with initialization block to this manager. */
inline fun <T> NodeManager.listSelectionView(
    init: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(ListSelectionView(), init)
}
