@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.PlusMinusSlider

/** Creates a [PlusMinusSlider]. */
fun plusMinusSlider(
    init: ((@LayoutDsl PlusMinusSlider).() -> Unit)? = null
): PlusMinusSlider = PlusMinusSlider().also { init?.invoke(it) }

/** Creates a [PlusMinusSlider] and add it to this manager. */
inline fun NodeManager.plusMinusSlider(
    noinline init: ((@LayoutDsl PlusMinusSlider).() -> Unit)? = null
): PlusMinusSlider = ktfx.controlsfx.plusMinusSlider(init)()