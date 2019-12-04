@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeCell
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXTreeCell] with initialization block. */
inline fun <T> jfxTreeCell(
    init: (@LayoutsDslMarker JFXTreeCell<T>).() -> Unit
): JFXTreeCell<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXTreeCell<T>().apply(init)
}

/** Add a [JFXTreeCell] to this manager. */
fun <T> NodeManager.jfxTreeCell(): JFXTreeCell<T> = addChild(JFXTreeCell())

/** Add a [JFXTreeCell] with initialization block to this manager. */
inline fun <T> NodeManager.jfxTreeCell(
    init: (@LayoutsDslMarker JFXTreeCell<T>).() -> Unit
): JFXTreeCell<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXTreeCell(), init)
}
