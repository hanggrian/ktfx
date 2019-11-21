@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.KtfxLayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXListView] with initialization. */
inline fun <T> jfxListView(
    init: (@KtfxLayoutsDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXListView<T>().apply(init)
}

/** Add a [JFXListView] to this manager. */
fun <T> NodeManager.jfxListView(): JFXListView<T> =
    addNode(JFXListView())

/** Add a [JFXListView] with initialization to this manager. */
inline fun <T> NodeManager.jfxListView(
    init: (@KtfxLayoutsDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXListView(), init)
}