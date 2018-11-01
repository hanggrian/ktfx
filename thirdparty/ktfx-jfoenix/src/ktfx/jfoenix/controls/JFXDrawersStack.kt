@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDrawersStack
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [JFXDrawersStack]. */
fun jfxDrawersStack(
    init: ((@LayoutDsl JFXDrawersStack).() -> Unit)? = null
): JFXDrawersStack = JFXDrawersStack().also { init?.invoke(it) }

/** Creates a [JFXDrawersStack] and add it to this manager. */
inline fun NodeManager.jfxDrawersStack(
    noinline init: ((@LayoutDsl JFXDrawersStack).() -> Unit)? = null
): JFXDrawersStack = ktfx.jfoenix.jfxDrawersStack(init)()