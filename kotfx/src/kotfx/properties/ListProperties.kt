@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.properties

import javafx.beans.property.SimpleListProperty
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList

/** Wrap this list in modifiable property. */
inline fun <E> ObservableList<E>?.toMutableProperty(): MutableListProperty<E> = SimpleListProperty(this)

/** Wrap this list in unmodifiable property. */
inline fun <E> ObservableList<E>?.toProperty(): ListProperty<E> = ListWrapper(this)

/** Returns this list property as an observable. */
inline fun <E> ListProperty<E>.asObservable(): ObservableValue<ObservableList<E>> = this