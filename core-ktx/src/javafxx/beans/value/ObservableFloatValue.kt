@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.value

import javafx.beans.value.ObservableFloatValue
import kotlin.reflect.KProperty

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableFloatValue.getValue(thisRef: Any?, property: KProperty<*>): Float = get()