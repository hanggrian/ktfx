@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.property

import javafx.beans.property.ReadOnlySetProperty
import javafx.beans.property.ReadOnlySetWrapper
import javafx.beans.property.SetProperty
import javafx.beans.property.SimpleSetProperty
import javafx.collections.ObservableSet

/** Wrap this set in unmodifiable property. */
inline fun <E> ObservableSet<E>?.toProperty(): ReadOnlySetProperty<E> = ReadOnlySetWrapper(this)

/** Wrap this set in modifiable property. */
inline fun <E> ObservableSet<E>?.toMutableProperty(): SetProperty<E> = SimpleSetProperty(this)