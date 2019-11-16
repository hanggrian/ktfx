@file:JvmMultifileClass
@file:JvmName("ObservableCollectionKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.collections.ObservableSet

private const val INT_MAX_POWER_OF_TWO: Int = Int.MAX_VALUE / 2 + 1

internal fun <T> ObservableList<T>.optimizeReadOnlyList(): ObservableList<T> = when (size) {
    0 -> emptyObservableList()
    1 -> observableListOf(this[0])
    else -> FXCollections.unmodifiableObservableList(this)
}

internal fun <T> ObservableSet<T>.optimizeReadOnlySet(): ObservableSet<T> = when (size) {
    0 -> emptyObservableSet()
    1 -> observableSetOf(iterator().next())
    else -> FXCollections.unmodifiableObservableSet(this)
}

internal fun mapCapacity(expectedSize: Int): Int {
    if (expectedSize < 3) {
        return expectedSize + 1
    }
    if (expectedSize < INT_MAX_POWER_OF_TWO) {
        return expectedSize + expectedSize / 3
    }
    return Int.MAX_VALUE // any large value
}
