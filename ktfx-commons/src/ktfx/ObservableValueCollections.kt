@file:JvmMultifileClass
@file:JvmName("ObservableValueKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.value.ObservableListValue
import javafx.beans.value.ObservableMapValue
import javafx.beans.value.ObservableSetValue
import javafx.beans.value.WritableListValue
import javafx.beans.value.WritableMapValue
import javafx.beans.value.WritableSetValue
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet
import kotlin.reflect.KProperty

/**
 * Delegated property, use with `by` keyword.
 *
 * @see ObservableListValue.get
 */
inline operator fun <E> ObservableListValue<E>.getValue(
    thisRef: Any?,
    property: KProperty<*>
): ObservableList<E> = get()

/**
 * Delegated property, use with `by` keyword.
 *
 * @see WritableListValue.set
 */
inline operator fun <E> WritableListValue<E>.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: ObservableList<E>
): Unit = set(value)

/**
 * Delegated property, use with `by` keyword.
 *
 * @see ObservableSetValue.get
 */
inline operator fun <E> ObservableSetValue<E>.getValue(
    thisRef: Any?,
    property: KProperty<*>
): ObservableSet<E> = get()

/**
 * Delegated property, use with `by` keyword.
 *
 * @see WritableSetValue.set
 */
inline operator fun <E> WritableSetValue<E>.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: ObservableSet<E>
): Unit = set(value)

/**
 * Delegated property, use with `by` keyword.
 *
 * @see ObservableMapValue.get
 */
inline operator fun <K, V> ObservableMapValue<K, V>.getValue(
    thisRef: Any?,
    property: KProperty<*>
): ObservableMap<K, V> = get()

/**
 * Delegated property, use with `by` keyword.
 *
 * @see WritableMapValue.set
 */
inline operator fun <K, V> WritableMapValue<K, V>.setValue(
    thisRef: Any?,
    property: KProperty<*>,
    value: ObservableMap<K, V>
): Unit = set(value)
