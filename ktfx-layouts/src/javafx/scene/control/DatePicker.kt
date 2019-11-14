@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import java.time.LocalDate
import javafx.scene.control.DatePicker
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [DatePicker] with initialization block. */
inline fun datePicker(
    date: LocalDate? = null,
    init: DatePicker.() -> Unit
): DatePicker {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return DatePicker(date).apply(init)
}

/** Add a [DatePicker] to this manager. */
fun NodeManager.datePicker(
    date: LocalDate? = null
): DatePicker = addNode(DatePicker(date))

/** Add a [DatePicker] with initialization block to this manager. */
inline fun NodeManager.datePicker(
    date: LocalDate? = null,
    init: DatePicker.() -> Unit
): DatePicker {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(DatePicker(date), init)
}
