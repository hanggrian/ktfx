@file:JvmMultifileClass
@file:JvmName("PropertiesKt")

package ktfx

import javafx.beans.property.ListProperty
import javafx.beans.property.MapProperty
import javafx.beans.property.ReadOnlyListWrapper
import javafx.beans.property.ReadOnlyMapWrapper
import javafx.beans.property.ReadOnlySetWrapper
import javafx.beans.property.SetProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleMapProperty
import javafx.beans.property.SimpleSetProperty
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet

/**
 * Wrap list in a JavaFX property.
 *
 * @param readOnly true when this is a read-only property, default is false.
 * @see SimpleListProperty
 * @see ReadOnlyListWrapper
 */
fun <E> ObservableList<E>?.asProperty(readOnly: Boolean = false): ListProperty<E> = when {
    readOnly -> ReadOnlyListWrapper(this)
    else -> SimpleListProperty(this)
}

/**
 * Wrap set in a JavaFX property.
 *
 * @param readOnly true when this is a read-only property, default is false.
 * @see SimpleSetProperty
 * @see ReadOnlySetWrapper
 */
fun <E> ObservableSet<E>?.asProperty(readOnly: Boolean = false): SetProperty<E> = when {
    readOnly -> ReadOnlySetWrapper(this)
    else -> SimpleSetProperty(this)
}

/**
 * Wrap map in a JavaFX property.
 *
 * @param readOnly true when this is a read-only property, default is false.
 * @see SimpleMapProperty
 * @see ReadOnlyMapWrapper
 */
fun <K, V> ObservableMap<K, V>?.asProperty(readOnly: Boolean = false): MapProperty<K, V> = when {
    readOnly -> ReadOnlyMapWrapper(this)
    else -> SimpleMapProperty(this)
}
