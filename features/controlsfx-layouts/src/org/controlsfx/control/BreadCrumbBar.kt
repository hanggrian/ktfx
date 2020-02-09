@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.control.TreeItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.BreadCrumbBar

/** Create a [BreadCrumbBar] with configurationialization block. */
inline fun <T> breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    configuration: (@LayoutDslMarker BreadCrumbBar<T>).() -> Unit
): BreadCrumbBar<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return BreadCrumbBar(selectedCrumb).apply(configuration)
}

/** Add a [BreadCrumbBar] to this manager. */
fun <T> NodeManager.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null
): BreadCrumbBar<T> = addChild(BreadCrumbBar(selectedCrumb))

/** Add a [BreadCrumbBar] with configurationialization block to this manager. */
inline fun <T> NodeManager.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    configuration: (@LayoutDslMarker BreadCrumbBar<T>).() -> Unit
): BreadCrumbBar<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(BreadCrumbBar(selectedCrumb), configuration)
}
