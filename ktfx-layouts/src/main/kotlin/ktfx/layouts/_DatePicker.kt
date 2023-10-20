@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import java.time.LocalDate
import javafx.scene.control.DatePicker
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [DatePicker] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.datePicker(date: LocalDate? = null): DatePicker = datePicker(date = date) {
        }

/**
 * Create a [DatePicker] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun datePicker(date: LocalDate? = null, configuration: (@KtfxLayoutDslMarker
        DatePicker).() -> Unit): DatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = DatePicker(date)
    child.configuration()
    return child
}

/**
 * Add a [DatePicker] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.datePicker(date: LocalDate? = null,
        configuration: (@KtfxLayoutDslMarker DatePicker).() -> Unit): DatePicker {
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
public fun styledDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null,
): DatePicker = styledDatePicker(date = date, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [DatePicker] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null,
): DatePicker = styledDatePicker(date = date, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [DatePicker] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker DatePicker).() -> Unit,
): DatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = DatePicker(date)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [DatePicker] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker DatePicker).() -> Unit,
): DatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = DatePicker(date)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
