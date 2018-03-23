@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollBar

inline fun scrollBar(noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }

inline fun Manager<Node>.scrollBar(noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null): ScrollBar = ktfx.layouts.scrollBar(init).add()