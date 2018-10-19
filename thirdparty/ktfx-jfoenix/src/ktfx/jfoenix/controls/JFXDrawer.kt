@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDrawer
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXDrawer]. */
fun jfxDrawer(
    init: ((@LayoutDsl JFXDrawer).() -> Unit)? = null
): JFXDrawer = JFXDrawer().also { init?.invoke(it) }

/** Creates a [JFXDrawer] and add it to this manager. */
inline fun NodeManager.jfxDrawer(
    noinline init: ((@LayoutDsl JFXDrawer).() -> Unit)? = null
): JFXDrawer = ktfx.jfoenix.jfxDrawer(init)()