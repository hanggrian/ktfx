@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.layout.Region

/** Creates a [Region]. */
fun region(
    init: ((@LayoutMarker Region).() -> Unit)? = null
): Region = Region().also { init?.invoke(it) }

/** Creates a [Region] and add it to this manager. */
inline fun NodeManager.region(
    noinline init: ((@LayoutMarker Region).() -> Unit)? = null
): Region = ktfx.layouts.region(init).add()