@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.control.TreeItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.BreadCrumbBar

/** Create a [BreadCrumbBar] with initialization block. */
inline fun <T> breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    init: BreadCrumbBar<T>.() -> Unit
): BreadCrumbBar<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return BreadCrumbBar(selectedCrumb).apply(init)
}

/** Add a [BreadCrumbBar] to this manager. */
fun <T> NodeManager.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null
): BreadCrumbBar<T> = addNode(BreadCrumbBar(selectedCrumb))

/** Add a [BreadCrumbBar] with initialization block to this manager. */
inline fun <T> NodeManager.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    init: BreadCrumbBar<T>.() -> Unit
): BreadCrumbBar<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(BreadCrumbBar(selectedCrumb), init)
}
