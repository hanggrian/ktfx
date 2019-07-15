@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.Rating

/** Creates a [Rating]. */
fun rating(
    max: Int = 5,
    rating: Int = -1,
    init: ((@LayoutDslMarker Rating).() -> Unit)? = null
): Rating = Rating(max, rating).also { init?.invoke(it) }

/** Creates a [Rating] and add it to this manager. */
inline fun NodeManager.rating(
    max: Int = 5,
    rating: Int = -1,
    noinline init: ((@LayoutDslMarker Rating).() -> Unit)? = null
): Rating = ktfx.controlsfx.rating(max, rating, init).add()
