@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.properties

import javafx.beans.property.SimpleLongProperty
import javafx.beans.value.ObservableValue

/** Wrap this long in modifiable property. */
inline fun Long?.toMutableProperty(): MutableLongProperty = SimpleLongProperty(this ?: 0)

/** Wrap this long in unmodifiable property. */
inline fun Long?.toProperty(): LongProperty = LongWrapper(this ?: 0)

/** Returns this long property as an observable. */
@Suppress("UNCHECKED_CAST")
inline fun LongProperty.asObservable(): ObservableValue<Long> = this as ObservableValue<Long>