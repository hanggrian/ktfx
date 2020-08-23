@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.control.CheckBoxTreeItem
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.CheckTreeView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CheckTreeView] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.checkTreeView(root: CheckBoxTreeItem<T>? = null): CheckTreeView<T> =
    checkTreeView(root = root) { }

/**
 * Create a [CheckTreeView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun <T> checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        CheckTreeView<T>
    ).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckTreeView<T>(root)
    child.configuration()
    return child
}

/**
 * Add a [CheckTreeView] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun <T> NodeManager.checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    configuration: (@KtfxLayoutDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckTreeView<T>(root)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [CheckTreeView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun <T> styledCheckTreeView(
    root: CheckBoxTreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): CheckTreeView<T> = styledCheckTreeView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CheckTreeView] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun <T> NodeManager.styledCheckTreeView(
    root: CheckBoxTreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): CheckTreeView<T> = styledCheckTreeView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CheckTreeView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun <T> styledCheckTreeView(
    root: CheckBoxTreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckTreeView<T>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [CheckTreeView] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledCheckTreeView(
    root: CheckBoxTreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckTreeView<T>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
