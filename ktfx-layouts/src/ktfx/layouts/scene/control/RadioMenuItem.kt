@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.RadioMenuItem

inline fun radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }

inline fun Manager<MenuItem>.radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = ktfx.layouts.radioMenuItem(text, graphic, init).add()