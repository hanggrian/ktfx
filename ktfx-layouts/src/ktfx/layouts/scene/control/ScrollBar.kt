@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.ScrollBar
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [ScrollBar]. */
fun scrollBar(
    init: ((@LayoutDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ScrollBar().also { init?.invoke(it) }

/** Creates a [ScrollBar] and add it to this manager. */
inline fun NodeInvokable.scrollBar(
    noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ktfx.layouts.scrollBar(init)()