@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem

inline fun customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@LayoutDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }
inline fun PopupManager.customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@LayoutDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = ktfx.layouts.customMenuItem(node, hideOnClick, init).add()