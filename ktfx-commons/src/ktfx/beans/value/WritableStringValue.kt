@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.value.WritableStringValue
import kotlin.reflect.KProperty

/** Delegated property, use with `by` keyword. */
inline operator fun WritableStringValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: String
): Unit = set(value)