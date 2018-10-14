@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXTogglePane
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXTogglePane]. */
fun jfxTogglePane(
    init: ((@LayoutDsl JFXTogglePane).() -> Unit)? = null
): JFXTogglePane = JFXTogglePane().also { init?.invoke(it) }

/** Creates a [JFXTogglePane] and add it to this manager. */
inline fun NodeManager.jfxTogglePane(
    noinline init: ((@LayoutDsl JFXTogglePane).() -> Unit)? = null
): JFXTogglePane = ktfx.jfoenix.jfxTogglePane(init)()