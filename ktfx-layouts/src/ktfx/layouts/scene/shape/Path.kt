@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Path
import javafx.scene.shape.PathElement

inline fun path(vararg elements: PathElement, noinline init: ((@LayoutDsl Path).() -> Unit)? = null): Path = Path(*elements).apply { init?.invoke(this) }
inline fun ChildManager.path(vararg elements: PathElement, noinline init: ((@LayoutDsl Path).() -> Unit)? = null): Path = ktfx.layouts.path(*elements, init = init).add()
inline fun ItemManager.path(vararg elements: PathElement, noinline init: ((@LayoutDsl Path).() -> Unit)? = null): Path = ktfx.layouts.path(*elements, init = init).add()
inline fun ButtonManager.path(vararg elements: PathElement, noinline init: ((@LayoutDsl Path).() -> Unit)? = null): Path = ktfx.layouts.path(*elements, init = init).add()