@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXChip] with configurationialization block. */
inline fun <T> jfxChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@LayoutDslMarker JFXChip<T>).() -> Unit
): JFXChip<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXChip(view, item).apply(configuration)
}

/** Add a [JFXChip] to this manager. */
fun <T> NodeManager.jfxChip(
    view: JFXChipView<T>,
    item: T
): JFXChip<T> = addChild(JFXChip(view, item))

/** Add a [JFXChip] with configurationialization block to this manager. */
inline fun <T> NodeManager.jfxChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@LayoutDslMarker JFXChip<T>).() -> Unit
): JFXChip<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXChip(view, item), configuration)
}
