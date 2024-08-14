@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.layouts

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
import org.controlsfx.control.ListSelectionView

/**
 * Add a [ListSelectionView] to this container.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.listSelectionView(): ListSelectionView<T> = listSelectionView()
        { }

/**
 * Create a [ListSelectionView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun <T> listSelectionView(configuration: (@KtfxLayoutDslMarker
        ListSelectionView<T>).() -> Unit): ListSelectionView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ListSelectionView<T>()
    child.configuration()
    return child
}

/**
 * Add a [ListSelectionView] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun <T> NodeContainer.listSelectionView(configuration: (@KtfxLayoutDslMarker
        ListSelectionView<T>).() -> Unit): ListSelectionView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ListSelectionView<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ListSelectionView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun <T> styledListSelectionView(vararg styleClass: String, id: String? = null):
        ListSelectionView<T> = styledListSelectionView(styleClass = styleClass, id = id) { }

/**
 * Add a styled [ListSelectionView] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledListSelectionView(vararg styleClass: String, id: String? =
        null): ListSelectionView<T> = styledListSelectionView(styleClass = styleClass, id = id) { }

/**
 * Create a styled [ListSelectionView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun <T> styledListSelectionView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ListSelectionView<T>).() -> Unit,
): ListSelectionView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ListSelectionView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ListSelectionView] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun <T> NodeContainer.styledListSelectionView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ListSelectionView<T>).() -> Unit,
): ListSelectionView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ListSelectionView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
