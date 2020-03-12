@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeView
import javafx.scene.control.TreeItem
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/**
 * Add a [JFXTreeView] to this manager.
 */
fun <T> NodeManager.jfxTreeView(root: TreeItem<T>? = null): JFXTreeView<T> = jfxTreeView(root =
        root) { }

/**
 * Create a [JFXTreeView] with configuration block.
 */
inline fun <T> jfxTreeView(
    root: TreeItem<T>? = null,
    configuration: (@LayoutDslMarker    
            JFXTreeView<T>).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXTreeView<T>(root), configuration = configuration)
}

/**
 * Add a [JFXTreeView] with configuration block to this manager.
 */
inline fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null,
    configuration: (@LayoutDslMarker    
            JFXTreeView<T>).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXTreeView<T>(root), configuration = configuration))
}

/**
 * Create a styled [JFXTreeView].
 */
fun <T> styledJFXTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTreeView<T> = styledJFXTreeView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTreeView] to this manager.
 */
fun <T> NodeManager.styledJFXTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTreeView<T> = styledJFXTreeView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTreeView] with configuration block.
 */
inline fun <T> styledJFXTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXTreeView<T>(root), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXTreeView] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledJFXTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXTreeView<T>(root), styleClass = *styleClass, id = id, configuration =
            configuration))
}
