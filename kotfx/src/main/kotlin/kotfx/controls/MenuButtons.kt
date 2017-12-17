@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.MenuButton
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.KotfxDsl

@JvmOverloads
inline fun menuButton(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl MenuButton).() -> Unit)? = null
): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.menuButton(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl MenuButton).() -> Unit)? = null
): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.menuButton(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl MenuButton).() -> Unit)? = null
): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }.add()