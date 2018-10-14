@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.control.Slider
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [Slider]. */
fun slider(
    min: Double,
    max: Double,
    value: Double,
    init: ((@LayoutDsl Slider).() -> Unit)? = null
): Slider = Slider(min, max, value).also { init?.invoke(it) }

/** Creates a [Slider] and add it to this manager. */
inline fun NodeManager.slider(
    min: Double,
    max: Double,
    value: Double,
    noinline init: ((@LayoutDsl Slider).() -> Unit)? = null
): Slider = ktfx.layouts.slider(min, max, value, init)()