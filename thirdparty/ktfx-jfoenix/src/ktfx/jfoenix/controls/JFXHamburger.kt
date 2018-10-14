@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXHamburger
import ktfx.annotations.LayoutDsl
import ktfx.NodeManager

/** Creates a [JFXHamburger]. */
fun jfxHamburger(
    init: ((@LayoutDsl JFXHamburger).() -> Unit)? = null
): JFXHamburger = JFXHamburger().also { init?.invoke(it) }

/** Creates a [JFXHamburger] and add it to this manager. */
inline fun NodeManager.jfxHamburger(
    noinline init: ((@LayoutDsl JFXHamburger).() -> Unit)? = null
): JFXHamburger = ktfx.jfoenix.jfxHamburger(init)()