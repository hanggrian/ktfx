@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.MenuItem
import kotfx.controls.PopupManager
import kotfx.internal.KotfxDsl

@JvmOverloads
inline fun menuItem(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl MenuItem).() -> Unit)? = null
): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun PopupManager.menuItem(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl MenuItem).() -> Unit)? = null
): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }.add()