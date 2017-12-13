@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.DatePicker
import kotfx.ChildManager
import kotfx.internal.ControlDsl
import java.time.LocalDate
import java.time.chrono.Chronology

class _DatePicker(date: LocalDate?) : DatePicker(date), _ComboBoxBase<DatePicker, LocalDate> {
    override val node: DatePicker get() = this

    fun chronology(value: Chronology) = setChronology(value)
    fun showWeekNumbers(value: Boolean) = setShowWeekNumbers(value)
}

@JvmOverloads
inline fun datePickerOf(
        date: LocalDate? = null,
        noinline init: ((@ControlDsl _DatePicker).() -> Unit)? = null
): DatePicker = _DatePicker(date).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.datePicker(
        date: LocalDate? = null,
        noinline init: ((@ControlDsl _DatePicker).() -> Unit)? = null
): DatePicker = datePickerOf(date, init).add()