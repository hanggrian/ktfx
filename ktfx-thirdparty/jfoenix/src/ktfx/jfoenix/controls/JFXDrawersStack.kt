@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDrawersStack
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutMarker

/** Creates a [JFXDrawersStack]. */
fun jfxDrawersStack(
    init: ((@LayoutMarker JFXDrawersStack).() -> Unit)? = null
): JFXDrawersStack = JFXDrawersStack().also { init?.invoke(it) }

/** Creates a [JFXDrawersStack] and add it to this manager. */
inline fun NodeManager.jfxDrawersStack(
    noinline init: ((@LayoutMarker JFXDrawersStack).() -> Unit)? = null
): JFXDrawersStack = ktfx.jfoenix.jfxDrawersStack(init).add()