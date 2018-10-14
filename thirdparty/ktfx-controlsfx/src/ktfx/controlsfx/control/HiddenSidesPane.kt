@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.HiddenSidesPane

/** Creates a [HiddenSidesPane]. */
fun hiddenSidesPane(
    content: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null,
    init: ((@LayoutDsl HiddenSidesPane).() -> Unit)? = null
): HiddenSidesPane = HiddenSidesPane(content, top, right, bottom, left).also { init?.invoke(it) }

/** Creates a [HiddenSidesPane] and add it to this manager. */
inline fun NodeManager.hiddenSidesPane(
    content: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null,
    noinline init: ((@LayoutDsl HiddenSidesPane).() -> Unit)? = null
): HiddenSidesPane = ktfx.controlsfx.hiddenSidesPane(content, top, right, bottom, left, init)()