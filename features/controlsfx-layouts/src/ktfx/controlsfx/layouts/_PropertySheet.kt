@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.ObservableList
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PropertySheet

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
inline fun propertySheet(items: ObservableList<PropertySheet.Item>? = null,
    configuration: (@LayoutDslMarker PropertySheet).() -> Unit): PropertySheet {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(PropertySheet(items), configuration = configuration)
}

/**
 * Add a [PropertySheet] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.propertySheet(items: ObservableList<PropertySheet.Item>? = null,
    configuration: (@LayoutDslMarker PropertySheet).() -> Unit): PropertySheet {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(PropertySheet(items), configuration = configuration))
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
  configuration: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(PropertySheet(items), styleClass = *styleClass, id = id, configuration =
      configuration)
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
  configuration: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(PropertySheet(items), styleClass = *styleClass, id = id, configuration =
      configuration))
}
