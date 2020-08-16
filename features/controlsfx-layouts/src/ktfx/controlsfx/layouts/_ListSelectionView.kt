@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.ListSelectionView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ListSelectionView] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.listSelectionView(): ListSelectionView<T> = listSelectionView() { }

/**
 * Create a [ListSelectionView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun <T> listSelectionView(configuration: (@LayoutDslMarker ListSelectionView<T>).() -> Unit):
    ListSelectionView<T> {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = ListSelectionView<T>()
        child.configuration()
        return child
    }

/**
 * Add a [ListSelectionView] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun <T> NodeManager.listSelectionView(
    configuration: (
        @LayoutDslMarker
        ListSelectionView<T>
    ).() -> Unit
): ListSelectionView<T> {
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
fun <T> styledListSelectionView(vararg styleClass: String, id: String? = null): ListSelectionView<T> =
    styledListSelectionView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ListSelectionView] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun <T> NodeManager.styledListSelectionView(vararg styleClass: String, id: String? = null):
    ListSelectionView<T> = styledListSelectionView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ListSelectionView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun <T> styledListSelectionView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ListSelectionView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ListSelectionView] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledListSelectionView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ListSelectionView<T>).() -> Unit
): ListSelectionView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ListSelectionView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
