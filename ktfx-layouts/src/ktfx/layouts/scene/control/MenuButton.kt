@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton

inline fun menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuButton).() -> Unit)? = null): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuButton).() -> Unit)? = null): MenuButton = ktfx.layouts.menuButton(text, graphic, init).add()
inline fun ItemManager.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuButton).() -> Unit)? = null): MenuButton = ktfx.layouts.menuButton(text, graphic, init).add()
inline fun ButtonManager.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuButton).() -> Unit)? = null): MenuButton = ktfx.layouts.menuButton(text, graphic, init).add()