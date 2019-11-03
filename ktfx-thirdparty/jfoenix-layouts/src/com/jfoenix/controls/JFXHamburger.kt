@file:Suppress("PackageDirectoryMismatch")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXHamburger
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXHamburger] with initialization block. */
inline fun jfxHamburger(
    init: (@LayoutDslMarker JFXHamburger).() -> Unit
): JFXHamburger = JFXHamburger().apply(init)

/** Add a [JFXHamburger] to this manager. */
fun NodeManager.jfxHamburger(): JFXHamburger =
    addNode(JFXHamburger())

/** Add a [JFXHamburger] with initialization block to this manager. */
inline fun NodeManager.jfxHamburger(
    init: (@LayoutDslMarker JFXHamburger).() -> Unit
): JFXHamburger = addNode(JFXHamburger(), init)
