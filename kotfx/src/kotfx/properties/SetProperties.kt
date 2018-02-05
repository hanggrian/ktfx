@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.properties

import javafx.beans.property.SimpleSetProperty
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableSet

/** Wrap this set in modifiable property. */
inline fun <E> ObservableSet<E>?.toMutableProperty(): MutableSetProperty<E> = SimpleSetProperty(this)

/** Wrap this set in unmodifiable property. */
inline fun <E> ObservableSet<E>?.toProperty(): SetProperty<E> = SetWrapper(this)

/** Returns this set property as an observable. */
inline fun <E> SetProperty<E>.asObservable(): ObservableValue<ObservableSet<E>> = this