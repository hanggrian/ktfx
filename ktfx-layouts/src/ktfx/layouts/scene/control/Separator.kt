@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.control.Separator

/** Add a [Separator] to this manager. */
fun NodeManager.separator(
    orientation: Orientation = HORIZONTAL
): Separator = Separator(orientation).add()

/** Add a [Separator] with initialization block to this manager. */
inline fun NodeManager.separator(
    orientation: Orientation = HORIZONTAL,
    init: (@LayoutDslMarker Separator).() -> Unit
): Separator = separator(orientation).apply(init).add()
