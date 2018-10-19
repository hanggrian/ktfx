@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.Slider
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [Slider]. */
fun slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    init: ((@LayoutDsl Slider).() -> Unit)? = null
): Slider = Slider(min, max, value).also { init?.invoke(it) }

/** Creates a [Slider] and add it to this manager. */
inline fun NodeManager.slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    noinline init: ((@LayoutDsl Slider).() -> Unit)? = null
): Slider = ktfx.layouts.slider(min, max, value, init)()