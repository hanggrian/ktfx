@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTabPane
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [JFXTabPane]. */
fun jfxTabPane(
    init: ((@LayoutDsl JFXTabPane).() -> Unit)? = null
): JFXTabPane = JFXTabPane().also { init?.invoke(it) }

/** Creates a [JFXTabPane] and add it to this manager. */
inline fun NodeManager.jfxTabPane(
    noinline init: ((@LayoutDsl JFXTabPane).() -> Unit)? = null
): JFXTabPane = ktfx.jfoenix.jfxTabPane(init)()