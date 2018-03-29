@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Path
import javafx.scene.shape.PathElement

inline fun path(
    vararg elements: PathElement
): Path = path(*elements) { }

inline fun path(
    vararg elements: PathElement,
    init: (@LayoutDsl Path).() -> Unit
): Path = Path(*elements).apply(init)

inline fun LayoutManager<Node>.path(
    vararg elements: PathElement
): Path = path(*elements) { }

inline fun LayoutManager<Node>.path(
    vararg elements: PathElement,
    init: (@LayoutDsl Path).() -> Unit
): Path = ktfx.layouts.path(*elements, init = init).add()