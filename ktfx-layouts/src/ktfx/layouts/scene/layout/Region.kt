@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.layout.Region

/** Create a [Region] with initialization block. */
inline fun region(
    init: (@LayoutDslMarker Region).() -> Unit
): Region = Region().apply(init)

/** Add a [Region] to this manager. */
fun NodeManager.region(): Region =
    addNode(ktfx.layouts.region { })

/** Add a [Region] with initialization block to this manager. */
inline fun NodeManager.region(
    init: (@LayoutDslMarker Region).() -> Unit
): Region = addNode(ktfx.layouts.region(init))
