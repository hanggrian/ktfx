@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Region

inline fun region(): Region = region { }

inline fun region(
    init: (@LayoutDsl Region).() -> Unit
): Region = Region().apply(init)

inline fun LayoutManager<Node>.region(): Region = region { }

inline fun LayoutManager<Node>.region(
    init: (@LayoutDsl Region).() -> Unit
): Region = ktfx.layouts.region(init).add()