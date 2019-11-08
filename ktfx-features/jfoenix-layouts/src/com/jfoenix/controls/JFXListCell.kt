@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListCell
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXListCell] with initialization block. */
inline fun <T> jfxListCell(
    init: JFXListCell<T>.() -> Unit
): JFXListCell<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXListCell<T>().apply(init)
}
/** Add a [JFXListCell] to this manager. */
fun <T> NodeManager.jfxListCell(): JFXListCell<T> =
    addNode(JFXListCell())

/** Add a [JFXListCell] with initialization block to this manager. */
inline fun <T> NodeManager.jfxListCell(
    init: JFXListCell<T>.() -> Unit
): JFXListCell<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXListCell(), init)
}
