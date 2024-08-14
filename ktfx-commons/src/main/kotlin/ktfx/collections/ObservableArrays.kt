@file:JvmMultifileClass
@file:JvmName("ObservableArraysKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.beans.binding.Bindings
import javafx.beans.binding.IntegerBinding
import javafx.collections.ObservableArray

/**
 * Returns the range of valid indices for the array.
 *
 * @see Array.indices
 */
public val ObservableArray<*>.indices: IntRange get() = IntRange(0, lastIndex)

/**
 * Returns the last valid index for the array.
 *
 * @see Array.lastIndex
 */
public val ObservableArray<*>.lastIndex: Int get() = size() - 1

/**
 * Returns `true` if the array is empty.
 *
 * @see Array.isEmpty
 */
public inline fun ObservableArray<*>.isEmpty(): Boolean = size() == 0

/**
 * Returns `true` if the array is not empty.
 *
 * @see Array.isNotEmpty
 */
public inline fun ObservableArray<*>.isNotEmpty(): Boolean = size() != 0

/** Creates a new [IntegerBinding] that contains the size of this array. */
public inline val ObservableArray<*>.sizeBinding: IntegerBinding get() = Bindings.size(this)
