@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Box
import javafx.scene.shape.Box.DEFAULT_SIZE

/** Create a [Box] with initialization block. */
inline fun box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    init: (@LayoutDslMarker Box).() -> Unit
): Box = Box(width, height, depth).apply(init)

/** Add a [Box] to this manager. */
fun NodeManager.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE
): Box = addNode(Box(width, height, depth))

/** Add a [Box] with initialization block to this manager. */
inline fun NodeManager.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    init: (@LayoutDslMarker Box).() -> Unit
): Box = addNode(Box(width, height, depth), init)
