@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.DatePicker
import java.time.LocalDate
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

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
inline fun datePicker(
    date: LocalDate? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        DatePicker
    ).() -> Unit
): DatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = DatePicker(date)
    child.configuration()
    return child
}

/**
 * Add a [DatePicker] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.datePicker(
    date: LocalDate? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        DatePicker
    ).() -> Unit
): DatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = DatePicker(date)
    child.configuration()
    return addChild(child)
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
    configuration: (@KtfxLayoutDslMarker DatePicker).() -> Unit
): DatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = DatePicker(date)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
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
    configuration: (@KtfxLayoutDslMarker DatePicker).() -> Unit
): DatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = DatePicker(date)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
