@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.value.WritableIntegerValue
import kotlin.reflect.KProperty

/** Delegated property, use with `by` keyword. */
inline operator fun WritableIntegerValue.setValue(thisRef: Any?, property: KProperty<*>, value: Int) = set(value)