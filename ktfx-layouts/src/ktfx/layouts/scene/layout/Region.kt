@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Region

inline fun region(noinline init: ((@LayoutDsl Region).() -> Unit)? = null): Region = Region().apply { init?.invoke(this) }

inline fun Manager<Node>.region(noinline init: ((@LayoutDsl Region).() -> Unit)? = null): Region = ktfx.layouts.region(init).add()