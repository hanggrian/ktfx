@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.beans.property.ObjectProperty
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.value.ObservableValue

/** Wrap this object in modifiable property. */
inline fun <T> T?.asMutableProperty(): ObjectProperty<T> = SimpleObjectProperty(this)

/** Wrap this object in unmodifiable property. */
inline fun <T> T?.asProperty(): ObjectProperty<T> = ReadOnlyObjectWrapper(this)

/** Returns this object property as an observable. */
inline fun <T> ObjectProperty<T>.asObservable(): ObservableValue<T> = this