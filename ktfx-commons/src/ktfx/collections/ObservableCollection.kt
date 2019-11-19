@file:JvmMultifileClass
@file:JvmName("ObservableCollectionKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.collections.ObservableSet

/**
 * @see kotlin.collections.optimizeReadOnlyList
 */
internal fun <T> ObservableList<T>.optimizeReadOnlyList(): ObservableList<T> = when (size) {
    0 -> emptyObservableList()
    1 -> observableListOf(this[0])
    else -> FXCollections.unmodifiableObservableList(this)
}

/**
 * @see kotlin.collections.optimizeReadOnlySet
 */
internal fun <T> ObservableSet<T>.optimizeReadOnlySet(): ObservableSet<T> = when (size) {
    0 -> emptyObservableSet()
    1 -> observableSetOf(iterator().next())
    else -> FXCollections.unmodifiableObservableSet(this)
}
