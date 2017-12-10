@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.properties

import javafx.beans.property.ReadOnlySetWrapper
import javafx.beans.property.SetProperty
import javafx.beans.property.SimpleSetProperty
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableSet

/** Wrap this set in modifiable property. */
inline fun <E> ObservableSet<E>?.asMutableProperty(): SetProperty<E> = SimpleSetProperty(this)

/** Wrap this set in unmodifiable property. */
inline fun <E> ObservableSet<E>?.asProperty(): SetProperty<E> = ReadOnlySetWrapper(this)

/** Returns this set property as an observable. */
inline fun <E> SetProperty<E>.asObservable(): ObservableValue<ObservableSet<E>> = this