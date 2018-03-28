@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.value.WritableLongValue
import kotlin.reflect.KProperty

inline operator fun WritableLongValue.setValue(thisRef: Any?, property: KProperty<*>, value: Long) = set(value)