@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.Menu
import kotfx.controls.MenuManager
import kotfx.controls.PopupManager
import kotfx.internal.KotfxDsl

@JvmOverloads
inline fun menu(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl Menu).() -> Unit)? = null
): Menu = Menu(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun PopupManager.menu(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl Menu).() -> Unit)? = null
): Menu = Menu(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun MenuManager.menu(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl Menu).() -> Unit)? = null
): Menu = Menu(text, graphic).apply { init?.invoke(this) }.add()