@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.properties

import javafx.beans.value.ObservableValue

/** Wrap this object in modifiable property. */
inline fun <T> T?.toMutableProperty(): MutableAnyProperty<T> = SimpleAnyProperty(this)

/** Wrap this object in unmodifiable property. */
inline fun <T> T?.toProperty(): MutableAnyProperty<T> = AnyWrapper(this)

/** Returns this property as an observable. */
inline fun <T> Property<T>.asObservable(): ObservableValue<T> = this