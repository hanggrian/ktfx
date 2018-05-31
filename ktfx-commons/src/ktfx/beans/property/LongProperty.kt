@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.property

import javafx.beans.property.LongProperty
import javafx.beans.property.ReadOnlyLongProperty
import javafx.beans.property.ReadOnlyLongWrapper
import javafx.beans.property.SimpleLongProperty
import javafx.beans.value.ObservableValue

/** Wrap this long in modifiable property. */
inline fun Long?.toMutableProperty(): LongProperty = SimpleLongProperty(this ?: 0)

/** Wrap this long in unmodifiable property. */
inline fun Long?.toProperty(): ReadOnlyLongProperty = ReadOnlyLongWrapper(this ?: 0)

/** Returns this long property as an observable. */
@Suppress("UNCHECKED_CAST")
inline fun LongProperty.asObservable(): ObservableValue<Long> = this as ObservableValue<Long>