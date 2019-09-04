@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Box
import javafx.scene.shape.Box.DEFAULT_SIZE

/** Add a [Box] to this manager. */
fun NodeManager.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE
): Box = Box(width, height, depth).add()

/** Add a [Box] with initialization block to this manager. */
inline fun NodeManager.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    init: (@LayoutDslMarker Box).() -> Unit
): Box = box(width, height, depth).apply(init)
