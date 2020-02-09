@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import java.time.LocalDate
import javafx.scene.control.DatePicker
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [DatePicker] with configurationialization block. */
inline fun datePicker(
    value: LocalDate? = null,
    configuration: (@LayoutDslMarker DatePicker).() -> Unit
): DatePicker {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return DatePicker(value).apply(configuration)
}

/** Add a [DatePicker] to this manager. */
fun NodeManager.datePicker(
    value: LocalDate? = null
): DatePicker = addChild(DatePicker(value))

/** Add a [DatePicker] with configurationialization block to this manager. */
inline fun NodeManager.datePicker(
    value: LocalDate? = null,
    configuration: (@LayoutDslMarker DatePicker).() -> Unit
): DatePicker {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(DatePicker(value), configuration)
}
