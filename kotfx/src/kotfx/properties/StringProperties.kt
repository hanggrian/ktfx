@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.properties

import javafx.beans.property.SimpleStringProperty
import javafx.beans.value.ObservableValue

/** Wrap this string in modifiable property. */
inline fun String?.toMutableProperty(): MutableStringProperty = SimpleStringProperty(this)

/** Wrap this string in unmodifiable property. */
inline fun String?.toProperty(): StringProperty = StringWrapper(this)

/** Returns this string property as an observable. */
inline fun StringProperty.asObservable(): ObservableValue<String> = this