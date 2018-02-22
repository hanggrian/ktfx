@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx

import javafx.beans.property.DoubleProperty
import javafx.beans.property.ReadOnlyDoubleProperty
import javafx.beans.property.ReadOnlyDoubleWrapper
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.value.ObservableValue

/** Wrap this double in modifiable property. */
inline fun Double?.toProperty(): DoubleProperty = SimpleDoubleProperty(this ?: 0.0)

/** Wrap this double in unmodifiable property. */
inline fun Double?.toReadOnlyProperty(): ReadOnlyDoubleProperty = ReadOnlyDoubleWrapper(this ?: 0.0)

/** Returns this double property as an observable. */
@Suppress("UNCHECKED_CAST")
inline fun DoubleProperty.asObservable(): ObservableValue<Double> = this as ObservableValue<Double>