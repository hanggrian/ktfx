@file:JvmMultifileClass
@file:JvmName("ObservableValuesKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableStringValue
import javafx.beans.value.ObservableValue
import javafx.beans.value.WritableBooleanValue
import javafx.beans.value.WritableDoubleValue
import javafx.beans.value.WritableFloatValue
import javafx.beans.value.WritableIntegerValue
import javafx.beans.value.WritableLongValue
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
inline operator fun ObservableBooleanValue.getValue(thisRef: Any?, property: KProperty<*>): Boolean = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableBooleanValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: Boolean
): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableDoubleValue.getValue(thisRef: Any?, property: KProperty<*>): Double = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableDoubleValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: Double
): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableFloatValue.getValue(thisRef: Any?, property: KProperty<*>): Float = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableFloatValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: Float
): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableIntegerValue.getValue(thisRef: Any?, property: KProperty<*>): Int = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableIntegerValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: Int
): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableLongValue.getValue(thisRef: Any?, property: KProperty<*>): Long = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableLongValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: Long
): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableStringValue.getValue(thisRef: Any?, property: KProperty<*>): String = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableStringValue.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: String
): Unit = set(value)