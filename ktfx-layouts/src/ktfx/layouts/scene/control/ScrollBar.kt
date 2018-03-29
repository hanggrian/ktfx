@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollBar

inline fun scrollBar(): ScrollBar = scrollBar { }

inline fun scrollBar(
    init: (@LayoutDsl ScrollBar).() -> Unit
): ScrollBar = ScrollBar().apply(init)

inline fun LayoutManager<Node>.scrollBar(): ScrollBar = scrollBar { }

inline fun LayoutManager<Node>.scrollBar(
    init: (@LayoutDsl ScrollBar).() -> Unit
): ScrollBar = ktfx.layouts.scrollBar(init).add()