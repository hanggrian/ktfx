@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.Slider

/** Create a [Slider] with initialization block. */
inline fun slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    init: (@LayoutDslMarker Slider).() -> Unit
): Slider = Slider(min, max, value).apply(init)

/** Add a [Slider] to this manager. */
fun NodeManager.slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0
): Slider = addNode(Slider(min, max, value))

/** Add a [Slider] with initialization block to this manager. */
inline fun NodeManager.slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    init: (@LayoutDslMarker Slider).() -> Unit
): Slider = addNode(Slider(min, max, value), init)
