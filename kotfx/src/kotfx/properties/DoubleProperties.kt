@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.properties

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.value.ObservableValue

/** Wrap this double in modifiable property. */
inline fun Double?.toMutableProperty(): MutableDoubleProperty = SimpleDoubleProperty(this ?: 0.0)

/** Wrap this double in unmodifiable property. */
inline fun Double?.toProperty(): DoubleProperty = DoubleWrapper(this ?: 0.0)

/** Returns this double property as an observable. */
@Suppress("UNCHECKED_CAST")
inline fun DoubleProperty.asObservable(): ObservableValue<Double> = this as ObservableValue<Double>