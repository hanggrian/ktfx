@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.Label
import kotfx.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.LayoutDsl

class _Label(text: String?, graphic: Node?) : Label(text, graphic), _Labeled<Label> {
    override val node: Label get() = this
}

@JvmOverloads
inline fun labelOf(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl _Label).() -> Unit)? = null
): Label = _Label(text, graphic).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.label(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl _Label).() -> Unit)? = null
): Label = labelOf(text, graphic, init).add()