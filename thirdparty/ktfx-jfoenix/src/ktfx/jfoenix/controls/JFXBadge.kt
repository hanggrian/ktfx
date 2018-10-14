@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXBadge
import javafx.geometry.Pos
import javafx.geometry.Pos.TOP_RIGHT
import javafx.scene.Node
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXBadge]. */
fun jfxBadge(
    control: Node? = null,
    pos: Pos = TOP_RIGHT,
    init: ((@LayoutDsl JFXBadge).() -> Unit)? = null
): JFXBadge = JFXBadge(control, pos).also { init?.invoke(it) }

/** Creates a [JFXBadge] and add it to this manager. */
inline fun NodeManager.jfxBadge(
    control: Node? = null,
    pos: Pos = TOP_RIGHT,
    noinline init: ((@LayoutDsl JFXBadge).() -> Unit)? = null
): JFXBadge = ktfx.jfoenix.jfxBadge(control, pos, init)()