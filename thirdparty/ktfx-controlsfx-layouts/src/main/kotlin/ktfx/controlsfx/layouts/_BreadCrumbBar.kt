@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.controlsfx.layouts

import javafx.scene.control.TreeItem
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer
import org.controlsfx.control.BreadCrumbBar

/**
 * Add a [BreadCrumbBar] to this container.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.breadCrumbBar(selectedCrumb: TreeItem<T>? = null):
        BreadCrumbBar<T> = breadCrumbBar(selectedCrumb = selectedCrumb) { }

/**
 * Create a [BreadCrumbBar] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <T> breadCrumbBar(selectedCrumb: TreeItem<T>? = null,
        configuration: (@KtfxLayoutDslMarker BreadCrumbBar<T>).() -> Unit): BreadCrumbBar<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = BreadCrumbBar<T>(selectedCrumb)
    child.configuration()
    return child
}

/**
 * Add a [BreadCrumbBar] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.breadCrumbBar(selectedCrumb: TreeItem<T>? = null,
        configuration: (@KtfxLayoutDslMarker BreadCrumbBar<T>).() -> Unit): BreadCrumbBar<T> {
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
public inline fun <T> styledBreadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
): BreadCrumbBar<T> = styledBreadCrumbBar(selectedCrumb = selectedCrumb, styleClass = styleClass, id
        = id) { }

/**
 * Add a styled [BreadCrumbBar] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledBreadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
): BreadCrumbBar<T> = styledBreadCrumbBar(selectedCrumb = selectedCrumb, styleClass = styleClass, id
        = id) { }

/**
 * Create a styled [BreadCrumbBar] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <T> styledBreadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker BreadCrumbBar<T>).() -> Unit,
): BreadCrumbBar<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = BreadCrumbBar<T>(selectedCrumb)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [BreadCrumbBar] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledBreadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker BreadCrumbBar<T>).() -> Unit,
): BreadCrumbBar<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = BreadCrumbBar<T>(selectedCrumb)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
