@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.Slider

/** Add a [Slider] to this manager. */
fun NodeManager.slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0
): Slider = Slider(min, max, value).add()

/** Add a [Slider] with initialization block to this manager. */
inline fun NodeManager.slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    init: (@LayoutDslMarker Slider).() -> Unit
): Slider = slider(min, max, value).apply(init)
