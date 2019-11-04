@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeCell
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTreeCell] with initialization block. */
inline fun <T> jfxTreeCell(
    init: (@LayoutDslMarker JFXTreeCell<T>).() -> Unit
): JFXTreeCell<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return JFXTreeCell<T>().apply(init)
}
/** Add a [JFXTreeCell] to this manager. */
fun <T> NodeManager.jfxTreeCell(): JFXTreeCell<T> =
    addNode(JFXTreeCell())

/** Add a [JFXTreeCell] with initialization block to this manager. */
inline fun <T> NodeManager.jfxTreeCell(
    init: (@LayoutDslMarker JFXTreeCell<T>).() -> Unit
): JFXTreeCell<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(JFXTreeCell(), init)
}
