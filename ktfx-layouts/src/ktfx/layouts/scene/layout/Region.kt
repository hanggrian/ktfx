@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.layout.Region

/** Add a [Region] to this manager. */
fun NodeManager.region(): Region =
    Region().add()

/** Add a [Region] with initialization block to this manager. */
inline fun NodeManager.region(
    init: (@LayoutDslMarker Region).() -> Unit
): Region = region().apply(init)
