@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXDefaultChip] with initialization block. */
inline fun <T> jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    init: JFXDefaultChip<T>.() -> Unit
): JFXDefaultChip<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXDefaultChip(view, item).apply(init)
}
/** Add a [JFXDefaultChip] to this manager. */
fun <T> NodeManager.jfxDefaultChip(
    view: JFXChipView<T>,
    item: T
): JFXDefaultChip<T> = addNode(JFXDefaultChip(view, item))

/** Add a [JFXDefaultChip] with initialization block to this manager. */
inline fun <T> NodeManager.jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    init: JFXDefaultChip<T>.() -> Unit
): JFXDefaultChip<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXDefaultChip(view, item), init)
}
