@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.properties

import javafx.beans.property.Property
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.ReadOnlyProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.value.ObservableValue

/** Wrap this object in modifiable property. */
inline fun <T> T?.toProperty(): Property<T> = SimpleObjectProperty(this)

/** Wrap this object in unmodifiable property. */
inline fun <T> T?.toReadOnlyProperty(): ReadOnlyProperty<T> = ReadOnlyObjectWrapper(this)

/** Returns this property as an observable. */
inline fun <T> Property<T>.asObservable(): ObservableValue<T> = this