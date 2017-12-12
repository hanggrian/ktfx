@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts.controls

import javafx.scene.Node
import javafx.scene.control.Label
import kotfx.internal.LayoutDsl
import kotfx.layouts.Noded

class _Label(text: String?, graphic: Node?) : Label(text, graphic) {

}

@JvmOverloads
inline fun label(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Label).() -> Unit)? = null
): Label = _Label(text, graphic).apply { if (init != null) init() }

@JvmOverloads
inline fun Noded.label(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Label).() -> Unit)? = null
): Label = addChild(_Label(text, graphic).apply { if (init != null) init() })