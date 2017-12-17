@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.Menu
import kotfx.internal.ControlDsl
import kotfx.internal.MenuManager
import kotfx.internal.PopupManager

@JvmOverloads
inline fun menuOf(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl Menu).() -> Unit)? = null
): Menu = Menu(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun PopupManager.menu(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl Menu).() -> Unit)? = null
): Menu = Menu(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun MenuManager.menu(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl Menu).() -> Unit)? = null
): Menu = Menu(text, graphic).apply { init?.invoke(this) }.add()