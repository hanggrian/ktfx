@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXHamburger
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXHamburger] to this manager. */
fun NodeManager.jfxHamburger(): JFXHamburger =
    JFXHamburger().add()

/** Add a [JFXHamburger] with initialization block to this manager. */
inline fun NodeManager.jfxHamburger(
    init: (@LayoutDslMarker JFXHamburger).() -> Unit
): JFXHamburger = jfxHamburger().apply(init)
