@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.Rating

/** Add a [Rating] to this manager. */
fun NodeManager.rating(
    max: Int = 5,
    rating: Int = -1
): Rating = Rating(max, rating).add()

/** Add a [Rating] with initialization block to this manager. */
inline fun NodeManager.rating(
    max: Int = 5,
    rating: Int = -1,
    init: (@LayoutDslMarker Rating).() -> Unit
): Rating = rating(max, rating).apply(init)
