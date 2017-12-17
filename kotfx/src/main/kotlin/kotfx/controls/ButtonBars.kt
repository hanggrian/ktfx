@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.ButtonBar
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun buttonBar(
        buttonOrder: String? = null,
        noinline init: ((@KotfxDsl ButtonBar).() -> Unit)? = null
): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.buttonBar(
        buttonOrder: String? = null,
        noinline init: ((@KotfxDsl ButtonBar).() -> Unit)? = null
): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.buttonBar(
        buttonOrder: String? = null,
        noinline init: ((@KotfxDsl ButtonBar).() -> Unit)? = null
): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }.add()