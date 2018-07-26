@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.property

import javafx.beans.property.ObjectProperty
import javafx.beans.property.ReadOnlyObjectProperty
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.value.ObservableValue

/** Wrap this object in unmodifiable property. */
inline fun <T> T?.toProperty(): ReadOnlyObjectProperty<T> = ReadOnlyObjectWrapper(this)

/** Wrap this object in modifiable property. */
inline fun <T> T?.toMutableProperty(): ObjectProperty<T> = SimpleObjectProperty(this)

inline fun ObservableValue<*>.hasValue(): Boolean = value != null