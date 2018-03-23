@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem

inline fun checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }
inline fun PopupManager.checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = ktfx.layouts.checkMenuItem(text, graphic, init).add()