@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.jfoenix

import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager

/** Creates a [JFXChip]. */
fun <T> jfxChip(
    view: JFXChipView<T>,
    item: T,
    init: ((@LayoutDsl JFXChip<T>).() -> Unit)? = null
): JFXChip<T> = JFXChip<T>(view, item).also {
    init?.invoke(it)
}

/** Creates a [JFXChip] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.jfxChip(
    view: JFXChipView<T>,
    item: T,
    noinline init: ((@LayoutDsl JFXChip<T>).() -> Unit)? = null
): JFXChip<T> = javafxx.layouts.jfoenix.jfxChip(view, item, init)()

/** Create a styled [JFXChip]. */
fun <T> styledJFXChip(
    styleClass: String,
    view: JFXChipView<T>,
    item: T,
    init: ((@LayoutDsl JFXChip<T>).() -> Unit)? = null
): JFXChip<T> = JFXChip<T>(view, item).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [JFXChip] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledJFXChip(
    styleClass: String,
    view: JFXChipView<T>,
    item: T,
    noinline init: ((@LayoutDsl JFXChip<T>).() -> Unit)? = null
): JFXChip<T> = javafxx.layouts.jfoenix.styledJFXChip(styleClass, view, item, init)()