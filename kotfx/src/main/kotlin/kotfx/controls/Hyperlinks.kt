@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.Hyperlink
import kotfx.internal.ChildManager
import kotfx.internal.LayoutDsl

class _Hyperlink(text: String?, graphic: Node?) : Hyperlink(text, graphic), _Labeled<Hyperlink> {
    override val control: Hyperlink get() = this

    fun visited(visited: Boolean) = setVisited(visited)
}

@JvmOverloads
inline fun hyperlink(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Hyperlink).() -> Unit)? = null
): Hyperlink = _Hyperlink(text, graphic).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.hyperlink(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Hyperlink).() -> Unit)? = null
): Hyperlink = _Hyperlink(text, graphic).apply { if (init != null) init() }.add()