@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts.controls

import javafx.scene.Node
import javafx.scene.control.Button
import kotfx.internal.LayoutDsl
import kotfx.internal.Noded

class _Button(text: String?, graphic: Node?) : Button(text, graphic) {

}

@JvmOverloads
inline fun button(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Button).() -> Unit)? = null
): Button = _Button(text, graphic).apply { if (init != null) init() }

@JvmOverloads
inline fun Noded.button(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Button).() -> Unit)? = null
): Button = _Button(text, graphic).apply { if (init != null) init() }.add()