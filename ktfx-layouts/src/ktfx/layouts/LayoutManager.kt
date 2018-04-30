package ktfx.layouts

import ktfx.internal.KtFXInternals.fail

/** Base interface for all layout managers. */
interface LayoutManager<C> {

    /** Should return the actual collection of this parent. */
    val childs: MutableList<C> get() = fail { "Childs is not initialized" }

    /** Add item to collection, returning the item added. */
    fun <T : C> T.add(): T = also { childs += it }
}