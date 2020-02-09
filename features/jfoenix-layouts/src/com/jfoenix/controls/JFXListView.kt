@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXListView] with configurationialization. */
inline fun <T> jfxListView(
    configuration: (@LayoutDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXListView<T>().apply(configuration)
}

/** Add a [JFXListView] to this manager. */
fun <T> NodeManager.jfxListView(): JFXListView<T> = addChild(JFXListView())

/** Add a [JFXListView] with configurationialization to this manager. */
inline fun <T> NodeManager.jfxListView(
    configuration: (@LayoutDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXListView(), configuration)
}
