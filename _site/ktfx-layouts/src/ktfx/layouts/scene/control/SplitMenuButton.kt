@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton

inline fun splitMenuButton(
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = SplitMenuButton(*items).also { init?.invoke(it) }

inline fun LayoutManager<Node>.splitMenuButton(
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = ktfx.layouts.splitMenuButton(*items, init = init).add()