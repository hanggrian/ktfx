@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXScrollPane
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXScrollPane]. */
fun jfxScrollPane(
    init: ((@LayoutDsl JFXScrollPane).() -> Unit)? = null
): JFXScrollPane = JFXScrollPane().also { init?.invoke(it) }

/** Creates a [JFXScrollPane] and add it to this manager. */
inline fun NodeManager.jfxScrollPane(
    noinline init: ((@LayoutDsl JFXScrollPane).() -> Unit)? = null
): JFXScrollPane = ktfx.jfoenix.jfxScrollPane(init)()