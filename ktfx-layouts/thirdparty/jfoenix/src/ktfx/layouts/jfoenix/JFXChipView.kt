@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts.jfoenix

import com.jfoenix.controls.JFXChipView
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXChipView]. */
fun <T> jfxChipView(
    init: ((@LayoutDsl JFXChipView<T>).() -> Unit)? = null
): JFXChipView<T> = JFXChipView<T>().also {
    init?.invoke(it)
}

/** Creates a [JFXChipView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.jfxChipView(
    noinline init: ((@LayoutDsl JFXChipView<T>).() -> Unit)? = null
): JFXChipView<T> = ktfx.layouts.jfoenix.jfxChipView(init)()

/** Create a styled [JFXChipView]. */
fun <T> styledJFXChipView(
    styleClass: String,
    init: ((@LayoutDsl JFXChipView<T>).() -> Unit)? = null
): JFXChipView<T> = JFXChipView<T>().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [JFXChipView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledJFXChipView(
    styleClass: String,
    noinline init: ((@LayoutDsl JFXChipView<T>).() -> Unit)? = null
): JFXChipView<T> = ktfx.layouts.jfoenix.styledJFXChipView(styleClass, init)()