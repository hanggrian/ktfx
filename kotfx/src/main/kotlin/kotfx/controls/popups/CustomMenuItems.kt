@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.popups

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun customMenuItem(
        node: Node? = null,
        hideOnClick: Boolean = true,
        noinline init: ((@ControlDsl CustomMenuItem).() -> Unit)? = null
): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }

@JvmOverloads
inline fun PopupManager.customMenuItem(
        node: Node? = null,
        hideOnClick: Boolean = true,
        noinline init: ((@ControlDsl CustomMenuItem).() -> Unit)? = null
): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }.add()