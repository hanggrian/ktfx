@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.control.ScrollBar
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [ScrollBar]. */
fun scrollBar(
    init: ((@LayoutDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ScrollBar().also { init?.invoke(it) }

/** Creates a [ScrollBar] and add it to this manager. */
inline fun NodeManager.scrollBar(
    noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ktfx.layouts.scrollBar(init)()