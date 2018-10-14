@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXToolbar
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXToolbar]. */
fun jfxToolbar(
    init: ((@LayoutDsl JFXToolbar).() -> Unit)? = null
): JFXToolbar = JFXToolbar().also { init?.invoke(it) }

/** Creates a [JFXToolbar] and add it to this manager. */
inline fun NodeManager.jfxToolbar(
    noinline init: ((@LayoutDsl JFXToolbar).() -> Unit)? = null
): JFXToolbar = ktfx.jfoenix.jfxToolbar(init)()