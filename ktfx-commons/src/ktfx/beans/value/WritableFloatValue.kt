@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.value.WritableFloatValue
import kotlin.reflect.KProperty

inline operator fun WritableFloatValue.setValue(thisRef: Any?, property: KProperty<*>, value: Float) = set(value)