@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXListView] with initialization. */
inline fun <T> jfxListView(
    init: (@LayoutsDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXListView<T>().apply(init)
}

/** Add a [JFXListView] to this manager. */
fun <T> NodeManager.jfxListView(): JFXListView<T> = addChild(JFXListView())

/** Add a [JFXListView] with initialization to this manager. */
inline fun <T> NodeManager.jfxListView(
    init: (@LayoutsDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXListView(), init)
}
