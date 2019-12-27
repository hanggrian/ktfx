@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeView
import javafx.scene.control.TreeItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXTreeView] with initialization block. */
inline fun <T> jfxTreeView(
    root: TreeItem<T>? = null,
    configuration: (@LayoutsDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXTreeView(root).apply(configuration)
}

/** Add a [JFXTreeView] to this manager. */
fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null
): JFXTreeView<T> = addChild(JFXTreeView(root))

/** Add a [JFXTreeView] with initialization block to this manager. */
inline fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null,
    configuration: (@LayoutsDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXTreeView(root), configuration)
}
