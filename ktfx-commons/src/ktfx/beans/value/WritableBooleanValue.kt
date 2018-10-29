@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.value.WritableBooleanValue
import kotlin.reflect.KProperty

/** Delegated property, use with `by` keyword. */
inline operator fun WritableBooleanValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: Boolean
): Unit = set(value)