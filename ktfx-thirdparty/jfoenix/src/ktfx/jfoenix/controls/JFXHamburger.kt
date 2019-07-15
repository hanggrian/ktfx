@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXHamburger
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXHamburger]. */
fun jfxHamburger(
    init: ((@LayoutDslMarker JFXHamburger).() -> Unit)? = null
): JFXHamburger = JFXHamburger().also { init?.invoke(it) }

/** Creates a [JFXHamburger] and add it to this manager. */
inline fun NodeManager.jfxHamburger(
    noinline init: ((@LayoutDslMarker JFXHamburger).() -> Unit)? = null
): JFXHamburger = ktfx.jfoenix.jfxHamburger(init).add()
