@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.Button
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.KotfxDsl

@JvmOverloads
inline fun button(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl Button).() -> Unit)? = null
): Button = Button(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.button(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl Button).() -> Unit)? = null
): Button = Button(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.button(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl Button).() -> Unit)? = null
): Button = Button(text, graphic).apply { init?.invoke(this) }.add()