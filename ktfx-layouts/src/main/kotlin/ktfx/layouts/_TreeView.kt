@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [TreeView] to this container.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.treeView(root: TreeItem<T>? = null): TreeView<T> = treeView(root
        = root) { }

/**
 * Create a [TreeView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <T> treeView(root: TreeItem<T>? = null, configuration: (@KtfxLayoutDslMarker
        TreeView<T>).() -> Unit): TreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TreeView<T>(root)
    child.configuration()
    return child
}

/**
 * Add a [TreeView] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.treeView(root: TreeItem<T>? = null,
        configuration: (@KtfxLayoutDslMarker TreeView<T>).() -> Unit): TreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TreeView<T>(root)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [TreeView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun <T> styledTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
): TreeView<T> = styledTreeView(root = root, styleClass = styleClass, id = id) { }

/**
 * Add a styled [TreeView] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
): TreeView<T> = styledTreeView(root = root, styleClass = styleClass, id = id) { }

/**
 * Create a styled [TreeView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <T> styledTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TreeView<T>).() -> Unit,
): TreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TreeView<T>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [TreeView] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TreeView<T>).() -> Unit,
): TreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TreeView<T>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
