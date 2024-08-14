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
import org.controlsfx.control.PrefixSelectionComboBox

/**
 * Add a [PrefixSelectionComboBox] to this container.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.prefixSelectionComboBox(): PrefixSelectionComboBox<T> =
        prefixSelectionComboBox() { }

/**
 * Create a [PrefixSelectionComboBox] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun <T> prefixSelectionComboBox(configuration: (@KtfxLayoutDslMarker
        PrefixSelectionComboBox<T>).() -> Unit): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PrefixSelectionComboBox<T>()
    child.configuration()
    return child
}

/**
 * Add a [PrefixSelectionComboBox] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun <T> NodeContainer.prefixSelectionComboBox(configuration: (@KtfxLayoutDslMarker
        PrefixSelectionComboBox<T>).() -> Unit): PrefixSelectionComboBox<T> {
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
public inline fun <T> styledPrefixSelectionComboBox(vararg styleClass: String, id: String? = null):
        PrefixSelectionComboBox<T> = styledPrefixSelectionComboBox(styleClass = styleClass, id = id)
        { }

/**
 * Add a styled [PrefixSelectionComboBox] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledPrefixSelectionComboBox(vararg styleClass: String,
        id: String? = null): PrefixSelectionComboBox<T> = styledPrefixSelectionComboBox(styleClass =
        styleClass, id = id) { }

/**
 * Create a styled [PrefixSelectionComboBox] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun <T> styledPrefixSelectionComboBox(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PrefixSelectionComboBox<T>).() -> Unit,
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PrefixSelectionComboBox<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [PrefixSelectionComboBox] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun <T> NodeContainer.styledPrefixSelectionComboBox(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PrefixSelectionComboBox<T>).() -> Unit,
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PrefixSelectionComboBox<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
