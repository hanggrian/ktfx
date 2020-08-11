@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import java.time.LocalDate
import javafx.scene.control.DatePicker
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [DatePicker] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.datePicker(date: LocalDate? = null): DatePicker = datePicker(date = date) { }

/**
 * Create a [DatePicker] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun datePicker(date: LocalDate? = null, configuration: (@LayoutDslMarker DatePicker).() ->
    Unit): DatePicker {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(DatePicker(date), configuration = configuration)
}

/**
 * Add a [DatePicker] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.datePicker(date: LocalDate? = null, configuration: (@LayoutDslMarker
    DatePicker).() -> Unit): DatePicker {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(DatePicker(date), configuration = configuration))
}

/**
 * Create a styled [DatePicker].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledDatePicker(
  date: LocalDate? = null,
  vararg styleClass: String,
  id: String? = null
): DatePicker = styledDatePicker(date = date, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [DatePicker] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledDatePicker(
  date: LocalDate? = null,
  vararg styleClass: String,
  id: String? = null
): DatePicker = styledDatePicker(date = date, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [DatePicker] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledDatePicker(
  date: LocalDate? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker DatePicker).() -> Unit
): DatePicker {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(DatePicker(date), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [DatePicker] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledDatePicker(
  date: LocalDate? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker DatePicker).() -> Unit
): DatePicker {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(DatePicker(date), styleClass = *styleClass, id = id, configuration =
      configuration))
}
