@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutDsl
import org.controlsfx.control.Rating

/** Creates a [Rating]. */
fun rating(
    max: Int = 5,
    rating: Int = -1,
    init: ((@LayoutDsl Rating).() -> Unit)? = null
): Rating = Rating(max, rating).also { init?.invoke(it) }

/** Creates a [Rating] and add it to this manager. */
inline fun NodeInvokable.rating(
    max: Int = 5,
    rating: Int = -1,
    noinline init: ((@LayoutDsl Rating).() -> Unit)? = null
): Rating = ktfx.controlsfx.rating(max, rating, init)()