@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.value.WritableDoubleValue
import kotlin.reflect.KProperty

/** Delegated property, use with `by` keyword. */
inline operator fun WritableDoubleValue.setValue(thisRef: Any?, property: KProperty<*>, value: Double) = set(value)