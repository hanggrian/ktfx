@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.Label
import kotfx.internal.ChildManager
import kotfx.internal.LayoutDsl

class _Label(text: String?, graphic: Node?) : Label(text, graphic), _Labeled<Label> {

    override val instance: Label get() = this

}

@JvmOverloads
inline fun label(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Label).() -> Unit)? = null
): Label = _Label(text, graphic).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.label(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Label).() -> Unit)? = null
): Label = _Label(text, graphic).apply { if (init != null) init() }.add()