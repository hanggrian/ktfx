@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.property

import javafx.beans.property.ListProperty
import javafx.beans.property.ReadOnlyListProperty
import javafx.beans.property.ReadOnlyListWrapper
import javafx.beans.property.SimpleListProperty
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList

/** Wrap this list in modifiable property. */
inline fun <E> ObservableList<E>?.toMutableProperty(): ListProperty<E> = SimpleListProperty(this)

/** Wrap this list in unmodifiable property. */
inline fun <E> ObservableList<E>?.toProperty(): ReadOnlyListProperty<E> = ReadOnlyListWrapper(this)

/** Returns this list property as an observable. */
inline fun <E> ListProperty<E>.asObservable(): ObservableValue<ObservableList<E>> = this