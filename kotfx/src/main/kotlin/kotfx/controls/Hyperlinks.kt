@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.Hyperlink
import kotfx.internal.LayoutDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun hyperlink(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.hyperlink(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }.add()