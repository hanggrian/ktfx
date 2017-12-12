@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts.controls

import javafx.scene.control.TextField
import kotfx.internal.LayoutDsl
import kotfx.layouts.Noded

class _TextField(text: String?) : TextField(text) {

}

@JvmOverloads
inline fun textField(
        text: String? = null,
        noinline init: ((@LayoutDsl _TextField).() -> Unit)? = null
): TextField = _TextField(text).apply { if (init != null) init() }

@JvmOverloads
inline fun Noded.textField(
        text: String? = null,
        noinline init: ((@LayoutDsl _TextField).() -> Unit)? = null
): TextField = addChild(_TextField(text).apply { if (init != null) init() })