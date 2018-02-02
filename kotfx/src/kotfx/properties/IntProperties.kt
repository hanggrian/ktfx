@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.properties

import javafx.beans.value.ObservableValue

/** Wrap this int in modifiable property. */
inline fun Int?.toMutableProperty(): IntProperty = SimpleIntProperty(this ?: 0)

/** Wrap this int in unmodifiable property. */
inline fun Int?.toProperty(): IntProperty = ReadOnlyIntWrapper(this ?: 0)

/** Returns this int property as an observable. */
@Suppress("UNCHECKED_CAST")
inline fun IntProperty.asObservable(): ObservableValue<Int> = this as ObservableValue<Int>