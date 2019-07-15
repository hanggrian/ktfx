@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.ScrollBar

/** Creates a [ScrollBar]. */
fun scrollBar(
    init: ((@LayoutDslMarker ScrollBar).() -> Unit)? = null
): ScrollBar = ScrollBar().also { init?.invoke(it) }

/** Creates a [ScrollBar] and add it to this manager. */
inline fun NodeManager.scrollBar(
    noinline init: ((@LayoutDslMarker ScrollBar).() -> Unit)? = null
): ScrollBar = ktfx.layouts.scrollBar(init).add()
