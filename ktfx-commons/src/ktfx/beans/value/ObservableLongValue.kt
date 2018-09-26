@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.value.ObservableLongValue
import kotlin.reflect.KProperty

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableLongValue.getValue(thisRef: Any?, property: KProperty<*>): Long = get()