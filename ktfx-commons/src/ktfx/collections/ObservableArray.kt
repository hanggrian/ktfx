@file:JvmMultifileClass
@file:JvmName("ObservableArrayKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.collections

import javafx.beans.binding.Bindings
import javafx.beans.binding.IntegerBinding
import javafx.collections.ObservableArray

/** Length of data in this array. */
inline val ObservableArray<*>.size: Int get() = size()

/** Returns `true` if the array is empty. */
inline fun ObservableArray<*>.isEmpty(): Boolean = size == 0

/** Returns `true` if the array is not empty. */
inline fun ObservableArray<*>.isNotEmpty(): Boolean = size != 0

/** Creates a new [IntegerBinding] that contains the size of this array. */
inline val ObservableArray<*>.sizeBinding: IntegerBinding get() = Bindings.size(this)
