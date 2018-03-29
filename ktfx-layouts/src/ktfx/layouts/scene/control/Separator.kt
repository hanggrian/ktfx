@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.control.Separator

inline fun separator(
    orientation: Orientation = HORIZONTAL
): Separator = separator(orientation) { }

inline fun separator(
    orientation: Orientation = HORIZONTAL,
    init: (@LayoutDsl Separator).() -> Unit
): Separator = Separator(orientation).apply(init)

inline fun LayoutManager<Node>.separator(
    orientation: Orientation = HORIZONTAL
): Separator = separator(orientation) { }

inline fun LayoutManager<Node>.separator(
    orientation: Orientation = HORIZONTAL,
    init: (@LayoutDsl Separator).() -> Unit
): Separator = ktfx.layouts.separator(orientation, init).add()