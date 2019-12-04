@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChipView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXChipView] with initialization block. */
inline fun <T> jfxChipView(
    init: (@LayoutsDslMarker JFXChipView<T>).() -> Unit
): JFXChipView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXChipView<T>().apply(init)
}

/** Add a [JFXChipView] to this manager. */
fun <T> NodeManager.jfxChipView(): JFXChipView<T> = addChild(JFXChipView())

/** Add a [JFXChipView] with initialization block to this manager. */
inline fun <T> NodeManager.jfxChipView(
    init: (@LayoutsDslMarker JFXChipView<T>).() -> Unit
): JFXChipView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXChipView(), init)
}
