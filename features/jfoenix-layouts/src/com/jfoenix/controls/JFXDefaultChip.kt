@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXDefaultChip] with configuration block. */
inline fun <T> jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@LayoutDslMarker JFXDefaultChip<T>).() -> Unit
): JFXDefaultChip<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXDefaultChip(view, item).apply(configuration)
}

/** Add a [JFXDefaultChip] to this manager. */
fun <T> NodeManager.jfxDefaultChip(
    view: JFXChipView<T>,
    item: T
): JFXDefaultChip<T> = addChild(JFXDefaultChip(view, item))

/** Add a [JFXDefaultChip] with configuration block to this manager. */
inline fun <T> NodeManager.jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@LayoutDslMarker JFXDefaultChip<T>).() -> Unit
): JFXDefaultChip<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXDefaultChip(view, item), configuration)
}
