@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXRippler
import com.jfoenix.controls.JFXRippler.RipplerMask
import com.jfoenix.controls.JFXRippler.RipplerPos
import javafx.scene.Node
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXRippler]. */
fun jfxRippler(
    control: Node? = null,
    mask: RipplerMask = RipplerMask.RECT,
    pos: RipplerPos = RipplerPos.FRONT,
    init: ((@LayoutDsl JFXRippler).() -> Unit)? = null
): JFXRippler = JFXRippler(control, mask, pos).also { init?.invoke(it) }

/** Creates a [JFXRippler] and add it to this manager. */
inline fun NodeManager.jfxRippler(
    control: Node? = null,
    mask: RipplerMask = RipplerMask.RECT,
    pos: RipplerPos = RipplerPos.FRONT,
    noinline init: ((@LayoutDsl JFXRippler).() -> Unit)? = null
): JFXRippler = ktfx.jfoenix.jfxRippler(control, mask, pos, init)()