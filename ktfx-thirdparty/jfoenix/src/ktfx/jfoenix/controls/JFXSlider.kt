@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXSlider
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXSlider] with initialization block. */
inline fun jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    init: (@LayoutDslMarker JFXSlider).() -> Unit
): JFXSlider = JFXSlider(min, max, value).apply(init)

/** Add a [JFXSlider] to this manager. */
fun NodeManager.jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0
): JFXSlider = addNode(ktfx.jfoenix.jfxSlider(min, max, value) { })

/** Add a [JFXSlider] with initialization block to this manager. */
inline fun NodeManager.jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    init: (@LayoutDslMarker JFXSlider).() -> Unit
): JFXSlider = addNode(ktfx.jfoenix.jfxSlider(min, max, value, init))