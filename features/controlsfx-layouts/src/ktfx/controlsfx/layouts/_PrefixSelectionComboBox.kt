@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PrefixSelectionComboBox
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [PrefixSelectionComboBox] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.prefixSelectionComboBox(): PrefixSelectionComboBox<T> =
    prefixSelectionComboBox() { }

/**
 * Create a [PrefixSelectionComboBox] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun <T> prefixSelectionComboBox(
    configuration: (
        @LayoutDslMarker
        PrefixSelectionComboBox<T>
    ).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PrefixSelectionComboBox<T>()
    child.configuration()
    return child
}

/**
 * Add a [PrefixSelectionComboBox] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun <T> NodeManager.prefixSelectionComboBox(
    configuration: (
        @LayoutDslMarker
        PrefixSelectionComboBox<T>
    ).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PrefixSelectionComboBox<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [PrefixSelectionComboBox].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun <T> styledPrefixSelectionComboBox(vararg styleClass: String, id: String? = null):
    PrefixSelectionComboBox<T> = styledPrefixSelectionComboBox(
        styleClass = *styleClass,
        id =
            id
    ) { }

/**
 * Add a styled [PrefixSelectionComboBox] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun <T> NodeManager.styledPrefixSelectionComboBox(vararg styleClass: String, id: String? = null):
    PrefixSelectionComboBox<T> = styledPrefixSelectionComboBox(
        styleClass = *styleClass,
        id =
            id
    ) { }

/**
 * Create a styled [PrefixSelectionComboBox] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun <T> styledPrefixSelectionComboBox(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PrefixSelectionComboBox<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [PrefixSelectionComboBox] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledPrefixSelectionComboBox(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PrefixSelectionComboBox<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
