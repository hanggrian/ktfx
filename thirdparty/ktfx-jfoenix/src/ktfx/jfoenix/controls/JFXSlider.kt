@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXSlider
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [JFXSlider]. */
fun jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    init: ((@LayoutDsl JFXSlider).() -> Unit)? = null
): JFXSlider = JFXSlider(min, max, value).also { init?.invoke(it) }

/** Creates a [JFXSlider] and add it to this manager. */
inline fun NodeInvokable.jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    noinline init: ((@LayoutDsl JFXSlider).() -> Unit)? = null
): JFXSlider = ktfx.jfoenix.jfxSlider(min, max, value, init)()