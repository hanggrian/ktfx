@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.scene.Node
import javafx.scene.control.Separator

inline fun separator(orientation: Orientation = Orientation.HORIZONTAL, noinline init: ((@LayoutDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }

inline fun Manager<Node>.separator(orientation: Orientation = Orientation.HORIZONTAL, noinline init: ((@LayoutDsl Separator).() -> Unit)? = null): Separator = ktfx.layouts.separator(orientation, init).add()