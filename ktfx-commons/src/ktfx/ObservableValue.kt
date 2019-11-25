@file:JvmMultifileClass
@file:JvmName("ObservableValueKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.value.ObservableValue
import javafx.beans.value.WritableObjectValue

/** Checks whether this observable contains a non-null value. */
inline fun ObservableValue<*>.hasValue(): Boolean = value != null

/** Sets the value to null with mutable property. */
inline fun WritableObjectValue<*>.clear(): Unit = setValue(null)
