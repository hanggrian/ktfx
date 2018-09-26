@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.value.WritableFloatValue
import kotlin.reflect.KProperty

/** Delegated property, use with `by` keyword. */
inline operator fun WritableFloatValue.setValue(thisRef: Any?, property: KProperty<*>, value: Float) = set(value)