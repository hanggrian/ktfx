@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.control.CheckBoxTreeItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.KtfxLayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.CheckTreeView

/** Create a [CheckTreeView] with initialization block. */
inline fun <T> checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    init: (@KtfxLayoutsDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return CheckTreeView(root).apply(init)
}

/** Add a [CheckTreeView] to this manager. */
fun <T> NodeManager.checkTreeView(
    root: CheckBoxTreeItem<T>? = null
): CheckTreeView<T> = addNode(CheckTreeView(root))

/** Add a [CheckTreeView] with initialization block to this manager. */
inline fun <T> NodeManager.checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    init: (@KtfxLayoutsDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(CheckTreeView(root), init)
}
