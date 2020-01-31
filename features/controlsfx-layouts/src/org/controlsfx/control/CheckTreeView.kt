@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.control.CheckBoxTreeItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.CheckTreeView

/** Create a [CheckTreeView] with initialization block. */
inline fun <T> checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    configuration: (@LayoutsDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return CheckTreeView(root).apply(configuration)
}

/** Add a [CheckTreeView] to this manager. */
fun <T> NodeManager.checkTreeView(
    root: CheckBoxTreeItem<T>? = null
): CheckTreeView<T> = addChild(CheckTreeView(root))

/** Add a [CheckTreeView] with initialization block to this manager. */
inline fun <T> NodeManager.checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    configuration: (@LayoutsDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(CheckTreeView(root), configuration)
}