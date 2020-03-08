@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.ObservableList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.PropertySheet

/** Create a [PropertySheet] with configuration block. */
inline fun propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    configuration: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return PropertySheet(items).apply(configuration)
}

/** Add a [PropertySheet] to this manager. */
fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null
): PropertySheet = addChild(PropertySheet(items))

/** Add a [PropertySheet] with configuration block to this manager. */
inline fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    configuration: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(PropertySheet(items), configuration)
}
