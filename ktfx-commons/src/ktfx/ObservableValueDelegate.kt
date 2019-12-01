@file:JvmMultifileClass
@file:JvmName("ObservableValueKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableListValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableMapValue
import javafx.beans.value.ObservableSetValue
import javafx.beans.value.ObservableStringValue
import javafx.beans.value.ObservableValue
import javafx.beans.value.WritableBooleanValue
import javafx.beans.value.WritableDoubleValue
import javafx.beans.value.WritableFloatValue
import javafx.beans.value.WritableIntegerValue
import javafx.beans.value.WritableListValue
import javafx.beans.value.WritableLongValue
import javafx.beans.value.WritableMapValue
import javafx.beans.value.WritableSetValue
import javafx.beans.value.WritableStringValue
import javafx.beans.value.WritableValue
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet
import kotlin.reflect.KProperty

/** Delegated property, use with `by` keyword. */
inline operator fun <V> ObservableValue<V>.getValue(ref: Any?, property: KProperty<*>): V? = value

/** Delegated property, use with `by` keyword. */
inline operator fun <V> WritableValue<in V>.setValue(ref: Any?, property: KProperty<*>, value: V?): Unit =
    setValue(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableStringValue.getValue(ref: Any?, property: KProperty<*>): String? = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableStringValue.setValue(ref: Any?, property: KProperty<*>, value: String?): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableBooleanValue.getValue(ref: Any?, property: KProperty<*>): Boolean = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableBooleanValue.setValue(ref: Any?, property: KProperty<*>, value: Boolean): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableDoubleValue.getValue(ref: Any?, property: KProperty<*>): Double = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableDoubleValue.setValue(ref: Any?, property: KProperty<*>, value: Double): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableFloatValue.getValue(ref: Any?, property: KProperty<*>): Float = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableFloatValue.setValue(ref: Any?, property: KProperty<*>, value: Float): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableIntegerValue.getValue(ref: Any?, property: KProperty<*>): Int = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableIntegerValue.setValue(ref: Any?, property: KProperty<*>, value: Int): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun ObservableLongValue.getValue(ref: Any?, property: KProperty<*>): Long = get()

/** Delegated property, use with `by` keyword. */
inline operator fun WritableLongValue.setValue(ref: Any?, property: KProperty<*>, value: Long): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun <E> ObservableListValue<E>.getValue(ref: Any?, property: KProperty<*>): ObservableList<E>? = get()

/** Delegated property, use with `by` keyword. */
inline operator fun <E> WritableListValue<E>.setValue(
    ref: Any?,
    property: KProperty<*>,
    value: ObservableList<E>?
): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun <E> ObservableSetValue<E>.getValue(ref: Any?, property: KProperty<*>): ObservableSet<E>? = get()

/** Delegated property, use with `by` keyword. */
inline operator fun <E> WritableSetValue<E>.setValue(
    ref: Any?,
    property: KProperty<*>,
    value: ObservableSet<E>?
): Unit = set(value)

/** Delegated property, use with `by` keyword. */
inline operator fun <K, V> ObservableMapValue<K, V>.getValue(ref: Any?, property: KProperty<*>): ObservableMap<K, V>? =
    get()

/** Delegated property, use with `by` keyword. */
inline operator fun <K, V> WritableMapValue<K, V>.setValue(
    ref: Any?,
    property: KProperty<*>,
    value: ObservableMap<K, V>?
): Unit = set(value)
