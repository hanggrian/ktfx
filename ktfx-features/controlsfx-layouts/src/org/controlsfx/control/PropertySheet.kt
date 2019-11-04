@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.ObservableList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.PropertySheet

/** Create a [PropertySheet] with initialization block. */
inline fun propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    init: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return PropertySheet(items).apply(init)
}
/** Add a [PropertySheet] to this manager. */
fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null
): PropertySheet = addNode(PropertySheet(items))

/** Add a [PropertySheet] with initialization block to this manager. */
inline fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    init: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(PropertySheet(items), init)
}
