@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.value.ObservableValue
import kotlin.reflect.KProperty

inline operator fun <V> ObservableValue<V>.getValue(thisRef: Any?, property: KProperty<*>): V = value