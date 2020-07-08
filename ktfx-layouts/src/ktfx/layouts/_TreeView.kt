@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [TreeView] to this manager.
 */
fun <T> NodeManager.treeView(root: TreeItem<T>? = null): TreeView<T> = treeView(root = root) { }

/**
 * Create a [TreeView] with configuration block.
 */
inline fun <T> treeView(
    root: TreeItem<T>? = null,
    configuration: (
        @LayoutDslMarker    
        TreeView<T>
    ).() -> Unit
): TreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(TreeView<T>(root), configuration = configuration)
}

/**
 * Add a [TreeView] with configuration block to this manager.
 */
inline fun <T> NodeManager.treeView(
    root: TreeItem<T>? = null,
    configuration: (
        @LayoutDslMarker    
        TreeView<T>
    ).() -> Unit
): TreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(TreeView<T>(root), configuration = configuration))
}

/**
 * Create a styled [TreeView].
 */
fun <T> styledTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): TreeView<T> = styledTreeView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TreeView] to this manager.
 */
fun <T> NodeManager.styledTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): TreeView<T> = styledTreeView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TreeView] with configuration block.
 */
inline fun <T> styledTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker TreeView<T>).() -> Unit
): TreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        TreeView<T>(root), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [TreeView] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker TreeView<T>).() -> Unit
): TreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            TreeView<T>(root), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}
