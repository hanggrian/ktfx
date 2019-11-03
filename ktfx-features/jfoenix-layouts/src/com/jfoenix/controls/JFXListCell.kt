@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListCell
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXListCell] with initialization block. */
inline fun <T> jfxListCell(
    init: (@LayoutDslMarker JFXListCell<T>).() -> Unit
): JFXListCell<T> = JFXListCell<T>().apply(init)

/** Add a [JFXListCell] to this manager. */
fun <T> NodeManager.jfxListCell(): JFXListCell<T> =
    addNode(JFXListCell())

/** Add a [JFXListCell] with initialization block to this manager. */
inline fun <T> NodeManager.jfxListCell(
    init: (@LayoutDslMarker JFXListCell<T>).() -> Unit
): JFXListCell<T> = addNode(JFXListCell(), init)
