@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.Hyperlink
import kotfx._Pane
import kotfx.internal.LayoutDsl

class _Hyperlink(text: String?, graphic: Node?) : Hyperlink(text, graphic), _Labeled<Hyperlink> {
    override val node: Hyperlink get() = this

    fun visited(value: Boolean) = setVisited(value)
}

@JvmOverloads
inline fun hyperlinkOf(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Hyperlink).() -> Unit)? = null
): Hyperlink = _Hyperlink(text, graphic).apply { if (init != null) init() }

@JvmOverloads
inline fun _Pane.hyperlink(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Hyperlink).() -> Unit)? = null
): Hyperlink = hyperlinkOf(text, graphic, init).add()