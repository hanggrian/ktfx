@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.popups

import javafx.scene.Node
import javafx.scene.control.Menu
import kotfx.internal.ControlDsl
import kotfx.layouts.PopupManager

@JvmOverloads
inline fun menu(
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