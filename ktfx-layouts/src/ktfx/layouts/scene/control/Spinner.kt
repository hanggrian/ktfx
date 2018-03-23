@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.Spinner

inline fun <T> spinner(noinline init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }
inline fun <T> ChildManager.spinner(noinline init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = ktfx.layouts.spinner(init).add()
inline fun <T> ItemManager.spinner(noinline init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = ktfx.layouts.spinner(init).add()
inline fun <T> ButtonManager.spinner(noinline init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = ktfx.layouts.spinner(init).add()