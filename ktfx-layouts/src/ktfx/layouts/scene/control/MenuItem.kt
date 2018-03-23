@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem

inline fun menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }
inline fun PopupManager.menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null): MenuItem = ktfx.layouts.menuItem(text, graphic, init).add()