@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.ScrollPane
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun scrollPane(
        content: Node? = null,
        noinline init: ((@KotfxDsl ScrollPane).() -> Unit)? = null
): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.scrollPane(
        content: Node? = null,
        noinline init: ((@KotfxDsl ScrollPane).() -> Unit)? = null
): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.scrollPane(
        content: Node? = null,
        noinline init: ((@KotfxDsl ScrollPane).() -> Unit)? = null
): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }.add()