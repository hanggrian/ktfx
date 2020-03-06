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
 */
fun NodeManager.datePicker(value: LocalDate): DatePicker = datePicker(value = value) { }

/**
 * Create a [DatePicker] with configuration block.
 */
inline fun datePicker(value: LocalDate, configuration: (@LayoutDslMarker DatePicker).() -> Unit):
        DatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(DatePicker(value), configuration = configuration)
}

/**
 * Add a [DatePicker] with configuration block to this manager.
 */
inline fun NodeManager.datePicker(value: LocalDate, configuration: (@LayoutDslMarker
        DatePicker).() -> Unit): DatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(DatePicker(value), configuration = configuration))
}

/**
 * Create a styled [DatePicker].
 */
fun styledDatePicker(value: LocalDate, vararg styleClass: String): DatePicker =
        styledDatePicker(value = value, styleClass = *styleClass) { }

/**
 * Add a styled [DatePicker] to this manager.
 */
fun NodeManager.styledDatePicker(value: LocalDate, vararg styleClass: String): DatePicker =
        styledDatePicker(value = value, styleClass = *styleClass) { }

/**
 * Create a styled [DatePicker] with configuration block.
 */
inline fun styledDatePicker(
    value: LocalDate,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker DatePicker).() -> Unit
): DatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(DatePicker(value), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [DatePicker] with configuration block to this manager.
 */
inline fun NodeManager.styledDatePicker(
    value: LocalDate,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker DatePicker).() -> Unit
): DatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(DatePicker(value), styleClass = *styleClass, configuration =
            configuration))
}
