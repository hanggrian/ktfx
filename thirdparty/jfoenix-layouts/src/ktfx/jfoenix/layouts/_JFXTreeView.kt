@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeView
import javafx.scene.control.TreeItem
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXTreeView] to this manager.
 *
 * @return the control added.
 */
public fun <T> NodeManager.jfxTreeView(root: TreeItem<T>? = null): JFXTreeView<T> = jfxTreeView(
    root =
    root
) { }

/**
 * Create a [JFXTreeView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <T> jfxTreeView(
    root: TreeItem<T>? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        JFXTreeView<T>
    ).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeView<T>(root)
    child.configuration()
    return child
}

/**
 * Add a [JFXTreeView] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeView<T>(root)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTreeView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun <T> styledJFXTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTreeView<T> = styledJFXTreeView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTreeView] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun <T> NodeManager.styledJFXTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTreeView<T> = styledJFXTreeView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTreeView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <T> styledJFXTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeView<T>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTreeView] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeManager.styledJFXTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeView<T>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
