@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Box
import javafx.scene.shape.Box.DEFAULT_SIZE

/** Creates a [Box]. */
fun box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    init: ((@LayoutMarker Box).() -> Unit)? = null
): Box = Box(width, height, depth).also { init?.invoke(it) }

/** Creates a [Box] and add it to this manager. */
inline fun NodeManager.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    noinline init: ((@LayoutMarker Box).() -> Unit)? = null
): Box = ktfx.layouts.box(width, height, depth, init).add()