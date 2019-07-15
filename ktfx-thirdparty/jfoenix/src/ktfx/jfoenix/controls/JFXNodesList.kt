@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXNodesList
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXNodesList]. */
fun jfxNodesList(
    init: ((@LayoutDslMarker JFXNodesList).() -> Unit)? = null
): JFXNodesList = JFXNodesList().also { init?.invoke(it) }

/** Creates a [JFXNodesList] and add it to this manager. */
inline fun NodeManager.jfxNodesList(
    noinline init: ((@LayoutDslMarker JFXNodesList).() -> Unit)? = null
): JFXNodesList = ktfx.jfoenix.jfxNodesList(init).add()
