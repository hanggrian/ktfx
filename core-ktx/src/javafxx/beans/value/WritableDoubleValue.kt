@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.value

import javafx.beans.value.WritableDoubleValue
import kotlin.reflect.KProperty

inline operator fun WritableDoubleValue.setValue(thisRef: Any?, property: KProperty<*>, value: Double) = set(value)