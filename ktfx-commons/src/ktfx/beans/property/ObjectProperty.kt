@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.property

import javafx.beans.property.ObjectProperty
import javafx.beans.property.ReadOnlyObjectProperty
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.value.ObservableValue
import javafx.beans.value.WritableObjectValue

/** Wrap this object in unmodifiable property. */
inline fun <T> T?.toProperty(): ReadOnlyObjectProperty<T> = ReadOnlyObjectWrapper(this)

/** Wrap this object in modifiable property. */
inline fun <T> T?.toMutableProperty(): ObjectProperty<T> = SimpleObjectProperty(this)

/** Checks whether this observable contains non-null value. */
inline fun ObservableValue<*>.hasValue(): Boolean = value != null

/** Sets the value to null with mutable property. */
inline fun WritableObjectValue<*>.clear() {
    value = null
}