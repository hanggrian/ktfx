@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.value

import javafx.beans.value.ObservableDoubleValue
import kotlin.reflect.KProperty

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableDoubleValue.getValue(thisRef: Any?, property: KProperty<*>): Double = get()