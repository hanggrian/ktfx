package javafxx.layouts

import javafxx.internal.Internals.fail

/** Base interface for all layout managers. */
interface LayoutManager<T> {

    /** Should return the actual collection of this parent. */
    val childs: MutableList<T> get() = fail { "Childs is not initialized" }

    /** Add item to collection, returning the item added. */
    operator fun <E : T> E.invoke(): E = also { childs += it }
}