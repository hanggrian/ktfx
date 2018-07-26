@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.value

import javafx.beans.value.WritableIntegerValue
import kotlin.reflect.KProperty

inline operator fun WritableIntegerValue.setValue(thisRef: Any?, property: KProperty<*>, value: Int) = set(value)