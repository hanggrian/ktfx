@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.property

import javafx.beans.property.ReadOnlyStringProperty
import javafx.beans.property.ReadOnlyStringWrapper
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.beans.value.ObservableValue

/** Wrap this string in modifiable property. */
inline fun String?.toProperty(): StringProperty = SimpleStringProperty(this)

/** Wrap this string in unmodifiable property. */
inline fun String?.toReadOnlyProperty(): ReadOnlyStringProperty = ReadOnlyStringWrapper(this)

/** Returns this string property as an observable. */
inline fun StringProperty.asObservable(): ObservableValue<String> = this