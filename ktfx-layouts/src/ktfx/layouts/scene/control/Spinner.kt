@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Spinner

inline fun <T> spinner(): Spinner<T> = spinner { }

inline fun <T> spinner(
    init: (@LayoutDsl Spinner<T>).() -> Unit
): Spinner<T> = Spinner<T>().apply(init)

inline fun <T> LayoutManager<Node>.spinner(): Spinner<T> = spinner { }

inline fun <T> LayoutManager<Node>.spinner(
    init: (@LayoutDsl Spinner<T>).() -> Unit
): Spinner<T> = ktfx.layouts.spinner(init).add()