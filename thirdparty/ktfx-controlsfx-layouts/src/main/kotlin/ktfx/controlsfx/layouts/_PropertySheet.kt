@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.controlsfx.layouts

import javafx.collections.ObservableList
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer
import org.controlsfx.control.PropertySheet

/**
 * Add a [PropertySheet] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.propertySheet(items: ObservableList<PropertySheet.Item>? = null):
        PropertySheet = propertySheet(items = items) { }

/**
 * Create a [PropertySheet] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun propertySheet(items: ObservableList<PropertySheet.Item>? = null,
        configuration: (@KtfxLayoutDslMarker PropertySheet).() -> Unit): PropertySheet {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PropertySheet(items)
    child.configuration()
    return child
}

/**
 * Add a [PropertySheet] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.propertySheet(items: ObservableList<PropertySheet.Item>? = null,
        configuration: (@KtfxLayoutDslMarker PropertySheet).() -> Unit): PropertySheet {
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
public inline fun styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null,
): PropertySheet = styledPropertySheet(items = items, styleClass = styleClass, id = id) { }

/**
 * Add a styled [PropertySheet] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null,
): PropertySheet = styledPropertySheet(items = items, styleClass = styleClass, id = id) { }

/**
 * Create a styled [PropertySheet] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PropertySheet).() -> Unit,
): PropertySheet {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PropertySheet(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [PropertySheet] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PropertySheet).() -> Unit,
): PropertySheet {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PropertySheet(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
