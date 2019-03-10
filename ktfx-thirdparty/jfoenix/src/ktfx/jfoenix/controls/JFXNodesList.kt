@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXNodesList
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutMarker

/** Creates a [JFXNodesList]. */
fun jfxNodesList(
    init: ((@LayoutMarker JFXNodesList).() -> Unit)? = null
): JFXNodesList = JFXNodesList().also { init?.invoke(it) }

/** Creates a [JFXNodesList] and add it to this manager. */
inline fun NodeManager.jfxNodesList(
    noinline init: ((@LayoutMarker JFXNodesList).() -> Unit)? = null
): JFXNodesList = ktfx.jfoenix.jfxNodesList(init).add()