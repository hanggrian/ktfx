@file:JvmMultifileClass
@file:JvmName("ObservableValuesKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.value.ObservableStringValue
import javafx.beans.value.ObservableValue
import javafx.beans.value.WritableObjectValue
import javafx.beans.value.WritableStringValue
import javafx.beans.value.WritableValue
import kotlin.reflect.KProperty

/** Checks whether this observable contains non-null value. */
inline fun ObservableValue<*>.hasValue(): Boolean = value != null

/** Sets the value to null with mutable property. */
inline fun WritableObjectValue<*>.clear() {
    value = null
}

/** Delegated property, use with `by` keyword. */
inline operator fun <V> ObservableValue<V>.getValue(thisRef: Any?, property: KProperty<*>): V? = value

/** Delegated property, use with `by` keyword. */
inline operator fun <V> WritableValue<in V>.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: V?
): Unit = setValue(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableStringValue.getValue(thisRef: Any?, property: KProperty<*>): String? = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableStringValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: String?
): Unit = set(value)