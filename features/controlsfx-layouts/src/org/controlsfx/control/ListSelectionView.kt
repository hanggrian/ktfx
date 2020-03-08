@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.ListSelectionView

/** Create a [ListSelectionView] with configuration block. */
inline fun <T> listSelectionView(
    configuration: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ListSelectionView<T>().apply(configuration)
}

/** Add a [ListSelectionView] to this manager. */
fun <T> NodeManager.listSelectionView(): ListSelectionView<T> = addChild(ListSelectionView())

/** Add a [ListSelectionView] with configuration block to this manager. */
inline fun <T> NodeManager.listSelectionView(
    configuration: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(ListSelectionView(), configuration)
}
