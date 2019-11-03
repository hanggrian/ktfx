@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXChip] with initialization block. */
inline fun <T> jfxChip(
    view: JFXChipView<T>,
    item: T,
    init: (@LayoutDslMarker JFXChip<T>).() -> Unit
): JFXChip<T> = JFXChip(view, item).apply(init)

/** Add a [JFXChip] to this manager. */
fun <T> NodeManager.jfxChip(
    view: JFXChipView<T>,
    item: T
): JFXChip<T> = addNode(JFXChip(view, item))

/** Add a [JFXChip] with initialization block to this manager. */
inline fun <T> NodeManager.jfxChip(
    view: JFXChipView<T>,
    item: T,
    init: (@LayoutDslMarker JFXChip<T>).() -> Unit
): JFXChip<T> = addNode(JFXChip(view, item), init)
