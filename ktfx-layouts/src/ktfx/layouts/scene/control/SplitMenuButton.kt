@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton

inline fun splitMenuButton(
    vararg items: MenuItem
): SplitMenuButton = splitMenuButton(*items) { }

inline fun splitMenuButton(
    vararg items: MenuItem,
    init: (@LayoutDsl SplitMenuButton).() -> Unit
): SplitMenuButton = SplitMenuButton(*items).apply(init)

inline fun LayoutManager<Node>.splitMenuButton(
    vararg items: MenuItem
): SplitMenuButton = splitMenuButton(*items) { }

inline fun LayoutManager<Node>.splitMenuButton(
    vararg items: MenuItem,
    init: (@LayoutDsl SplitMenuButton).() -> Unit
): SplitMenuButton = ktfx.layouts.splitMenuButton(*items, init = init).add()