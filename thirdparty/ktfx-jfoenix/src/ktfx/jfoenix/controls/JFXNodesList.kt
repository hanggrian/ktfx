@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXNodesList
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [JFXNodesList]. */
fun jfxNodesList(
    init: ((@LayoutDsl JFXNodesList).() -> Unit)? = null
): JFXNodesList = JFXNodesList().also { init?.invoke(it) }

/** Creates a [JFXNodesList] and add it to this manager. */
inline fun NodeManager.jfxNodesList(
    noinline init: ((@LayoutDsl JFXNodesList).() -> Unit)? = null
): JFXNodesList = ktfx.jfoenix.jfxNodesList(init)()