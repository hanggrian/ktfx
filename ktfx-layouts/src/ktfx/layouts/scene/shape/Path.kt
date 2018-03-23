@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Path
import javafx.scene.shape.PathElement

inline fun path(
    vararg elements: PathElement,
    noinline init: ((@LayoutDsl Path).() -> Unit)? = null
): Path = Path(*elements).also { init?.invoke(it) }

inline fun LayoutManager<Node>.path(
    vararg elements: PathElement,
    noinline init: ((@LayoutDsl Path).() -> Unit)? = null
): Path = ktfx.layouts.path(*elements, init = init).add()