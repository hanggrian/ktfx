@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.properties

import javafx.beans.property.ListProperty
import javafx.beans.property.ReadOnlyListProperty
import javafx.beans.property.ReadOnlyListWrapper
import javafx.beans.property.SimpleListProperty
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList

/** Wrap this list in modifiable property. */
inline fun <E> ObservableList<E>?.toProperty(): ListProperty<E> = SimpleListProperty(this)

/** Wrap this list in unmodifiable property. */
inline fun <E> ObservableList<E>?.toReadOnlyProperty(): ReadOnlyListProperty<E> = ReadOnlyListWrapper(this)

/** Returns this list property as an observable. */
inline fun <E> ListProperty<E>.asObservable(): ObservableValue<ObservableList<E>> = this