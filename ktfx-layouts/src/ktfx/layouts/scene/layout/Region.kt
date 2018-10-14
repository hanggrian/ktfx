@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.layout.Region
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [Region]. */
fun region(
    init: ((@LayoutDsl Region).() -> Unit)? = null
): Region = Region().also { init?.invoke(it) }

/** Creates a [Region] and add it to this manager. */
inline fun NodeManager.region(
    noinline init: ((@LayoutDsl Region).() -> Unit)? = null
): Region = ktfx.layouts.region(init)()