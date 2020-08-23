@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.ObservableList
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PropertySheet
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [PropertySheet] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.propertySheet(items: ObservableList<PropertySheet.Item>? = null): PropertySheet =
    propertySheet(items = items) { }

/**
 * Create a [PropertySheet] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    configuration: (@KtfxLayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PropertySheet(items)
    child.configuration()
    return child
}

/**
 * Add a [PropertySheet] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    configuration: (@KtfxLayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PropertySheet(items)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [PropertySheet].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null
): PropertySheet = styledPropertySheet(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [PropertySheet] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null
): PropertySheet = styledPropertySheet(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [PropertySheet] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PropertySheet(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [PropertySheet] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PropertySheet(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
