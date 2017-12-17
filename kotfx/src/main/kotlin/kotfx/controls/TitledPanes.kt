@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.TitledPane
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun titledPane(
        text: String? = null,
        content: Node? = null,
        noinline init: ((@KotfxDsl TitledPane).() -> Unit)? = null
): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.titledPane(
        text: String? = null,
        content: Node? = null,
        noinline init: ((@KotfxDsl TitledPane).() -> Unit)? = null
): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.titledPane(
        text: String? = null,
        content: Node? = null,
        noinline init: ((@KotfxDsl TitledPane).() -> Unit)? = null
): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }.add()