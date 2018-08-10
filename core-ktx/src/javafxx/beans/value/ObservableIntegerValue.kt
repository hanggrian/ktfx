@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.value

import javafx.beans.value.ObservableIntegerValue
import kotlin.reflect.KProperty

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableIntegerValue.getValue(thisRef: Any?, property: KProperty<*>): Int = get()