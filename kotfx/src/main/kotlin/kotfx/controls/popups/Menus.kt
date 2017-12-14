@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.popups

import javafx.scene.Node
import javafx.scene.control.Menu
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun menu(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl Menu).() -> Unit)? = null
): Menu = Menu(text, graphic).apply { init?.invoke(this) }