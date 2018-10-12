@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.layout.Region

/** Creates a [Region]. */
fun region(
    init: ((@LayoutDsl Region).() -> Unit)? = null
): Region = Region().also { init?.invoke(it) }

/** Creates a [Region] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.region(
    noinline init: ((@LayoutDsl Region).() -> Unit)? = null
): Region = ktfx.layouts.region(init)()