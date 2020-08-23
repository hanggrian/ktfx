@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.control.TreeItem
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.BreadCrumbBar
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [BreadCrumbBar] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.breadCrumbBar(selectedCrumb: TreeItem<T>? = null): BreadCrumbBar<T> =
    breadCrumbBar(selectedCrumb = selectedCrumb) { }

/**
 * Create a [BreadCrumbBar] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun <T> breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    configuration: (@KtfxLayoutDslMarker BreadCrumbBar<T>).() -> Unit
): BreadCrumbBar<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = BreadCrumbBar<T>(selectedCrumb)
    child.configuration()
    return child
}

/**
 * Add a [BreadCrumbBar] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun <T> NodeManager.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    configuration: (@KtfxLayoutDslMarker BreadCrumbBar<T>).() -> Unit
): BreadCrumbBar<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = BreadCrumbBar<T>(selectedCrumb)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [BreadCrumbBar].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun <T> styledBreadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): BreadCrumbBar<T> = styledBreadCrumbBar(
    selectedCrumb = selectedCrumb, styleClass = *styleClass,
    id = id
) { }

/**
 * Add a styled [BreadCrumbBar] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun <T> NodeManager.styledBreadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): BreadCrumbBar<T> = styledBreadCrumbBar(
    selectedCrumb = selectedCrumb, styleClass = *styleClass,
    id = id
) { }

/**
 * Create a styled [BreadCrumbBar] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun <T> styledBreadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker BreadCrumbBar<T>).() -> Unit
): BreadCrumbBar<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = BreadCrumbBar<T>(selectedCrumb)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [BreadCrumbBar] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledBreadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker BreadCrumbBar<T>).() -> Unit
): BreadCrumbBar<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = BreadCrumbBar<T>(selectedCrumb)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
