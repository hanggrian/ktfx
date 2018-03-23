@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.control.Separator

inline fun separator(
    orientation: Orientation = HORIZONTAL,
    noinline init: ((@LayoutDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).also { init?.invoke(it) }

inline fun LayoutManager<Node>.separator(
    orientation: Orientation = HORIZONTAL,
    noinline init: ((@LayoutDsl Separator).() -> Unit)? = null
): Separator = ktfx.layouts.separator(orientation, init).add()