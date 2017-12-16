@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.MenuButton
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun menuButtonOf(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl MenuButton).() -> Unit)? = null
): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.menuButton(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl MenuButton).() -> Unit)? = null
): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.menuButton(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl MenuButton).() -> Unit)? = null
): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }.add()