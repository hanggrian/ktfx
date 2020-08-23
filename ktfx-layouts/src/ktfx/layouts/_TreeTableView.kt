@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [TreeTableView] to this manager.
 *
 * @return the control added.
 */
fun <S> NodeManager.treeTableView(root: TreeItem<S>? = null): TreeTableView<S> = treeTableView(
    root =
        root
) { }

/**
 * Create a [TreeTableView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun <S> treeTableView(
    root: TreeItem<S>? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        TreeTableView<S>
    ).() -> Unit
): TreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TreeTableView<S>(root)
    child.configuration()
    return child
}

/**
 * Add a [TreeTableView] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun <S> NodeManager.treeTableView(
    root: TreeItem<S>? = null,
    configuration: (@KtfxLayoutDslMarker TreeTableView<S>).() -> Unit
): TreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TreeTableView<S>(root)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [TreeTableView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun <S> styledTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null
): TreeTableView<S> = styledTreeTableView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TreeTableView] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun <S> NodeManager.styledTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null
): TreeTableView<S> = styledTreeTableView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TreeTableView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun <S> styledTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TreeTableView<S>).() -> Unit
): TreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TreeTableView<S>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [TreeTableView] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun <S> NodeManager.styledTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TreeTableView<S>).() -> Unit
): TreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TreeTableView<S>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
