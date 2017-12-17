@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.Tab
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun tab(
        text: String? = null,
        content: Node? = null,
        noinline init: ((@KotfxDsl Tab).() -> Unit)? = null
): Tab = Tab(text, content).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.tab(
        text: String? = null,
        content: Node? = null,
        noinline init: ((@KotfxDsl Tab).() -> Unit)? = null
): Tab = Tab(text, content).apply { init?.invoke(this) }

@JvmOverloads
inline fun ItemManager.tab(
        text: String? = null,
        content: Node? = null,
        noinline init: ((@KotfxDsl Tab).() -> Unit)? = null
): Tab = Tab(text, content).apply { init?.invoke(this) }