@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.properties

import javafx.beans.property.ReadOnlyStringWrapper
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.beans.value.ObservableValue

/** Wrap this string in modifiable property. */
inline fun String?.asMutableProperty(): StringProperty = SimpleStringProperty(this)

/** Wrap this string in unmodifiable property. */
inline fun String?.asProperty(): StringProperty = ReadOnlyStringWrapper(this)

/** Returns this string property as an observable. */
inline fun StringProperty.asObservable(): ObservableValue<String> = this