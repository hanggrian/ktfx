@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem
import kotfx.internal.KotfxDsl
import kotfx.internal.PopupManager

@JvmOverloads
inline fun customMenuItem(
        node: Node? = null,
        hideOnClick: Boolean = true,
        noinline init: ((@KotfxDsl CustomMenuItem).() -> Unit)? = null
): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }

@JvmOverloads
inline fun PopupManager.customMenuItem(
        node: Node? = null,
        hideOnClick: Boolean = true,
        noinline init: ((@KotfxDsl CustomMenuItem).() -> Unit)? = null
): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }.add()