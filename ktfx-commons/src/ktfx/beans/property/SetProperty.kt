@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.property

import javafx.beans.property.ReadOnlySetProperty
import javafx.beans.property.ReadOnlySetWrapper
import javafx.beans.property.SetProperty
import javafx.beans.property.SimpleSetProperty
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableSet

/** Wrap this set in modifiable property. */
inline fun <E> ObservableSet<E>?.toProperty(): SetProperty<E> = SimpleSetProperty(this)

/** Wrap this set in unmodifiable property. */
inline fun <E> ObservableSet<E>?.toReadOnlyProperty(): ReadOnlySetProperty<E> = ReadOnlySetWrapper(this)

/** Returns this set property as an observable. */
inline fun <E> SetProperty<E>.asObservable(): ObservableValue<ObservableSet<E>> = this