@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDrawersStack
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXDrawersStack]. */
fun jfxDrawersStack(
    init: ((@LayoutDslMarker JFXDrawersStack).() -> Unit)? = null
): JFXDrawersStack = JFXDrawersStack().also { init?.invoke(it) }

/** Creates a [JFXDrawersStack] and add it to this manager. */
inline fun NodeManager.jfxDrawersStack(
    noinline init: ((@LayoutDslMarker JFXDrawersStack).() -> Unit)? = null
): JFXDrawersStack = ktfx.jfoenix.jfxDrawersStack(init).add()
