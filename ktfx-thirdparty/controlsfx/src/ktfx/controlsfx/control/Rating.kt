@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.Rating

/** Create a [Rating] with initialization block. */
inline fun rating(
    max: Int = 5,
    rating: Int = -1,
    init: (@LayoutDslMarker Rating).() -> Unit
): Rating = Rating(max, rating).apply(init)

/** Add a [Rating] to this manager. */
fun NodeManager.rating(
    max: Int = 5,
    rating: Int = -1
): Rating = addNode(ktfx.controlsfx.rating(max, rating) { })

/** Add a [Rating] with initialization block to this manager. */
inline fun NodeManager.rating(
    max: Int = 5,
    rating: Int = -1,
    init: (@LayoutDslMarker Rating).() -> Unit
): Rating = addNode(ktfx.controlsfx.rating(max, rating, init))
