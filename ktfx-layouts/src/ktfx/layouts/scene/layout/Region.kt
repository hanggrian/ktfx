@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Region

/** Create a [Region]. */
inline fun region(): Region = region { }

/** Create a [Region] with initialization. */
inline fun region(
    init: (@LayoutDsl Region).() -> Unit
): Region = Region().apply(init)

/** Create a [Region] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.region(): Region = region { }

/** Create a [Region] with initialization and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.region(
    init: (@LayoutDsl Region).() -> Unit
): Region = ktfx.layouts.region(init).add()