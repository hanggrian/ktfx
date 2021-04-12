@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PrefixSelectionChoiceBox
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [PrefixSelectionChoiceBox] to this manager.
 *
 * @return the control added.
 */
public fun <T> NodeManager.prefixSelectionChoiceBox(): PrefixSelectionChoiceBox<T> =
    prefixSelectionChoiceBox() { }

/**
 * Create a [PrefixSelectionChoiceBox] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun <T> prefixSelectionChoiceBox(
    configuration: (
        @KtfxLayoutDslMarker
        PrefixSelectionChoiceBox<T>
    ).() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PrefixSelectionChoiceBox<T>()
    child.configuration()
    return child
}

/**
 * Add a [PrefixSelectionChoiceBox] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun <T> NodeManager.prefixSelectionChoiceBox(
    configuration: (
        @KtfxLayoutDslMarker
        PrefixSelectionChoiceBox<T>
    ).() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PrefixSelectionChoiceBox<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [PrefixSelectionChoiceBox].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun <T> styledPrefixSelectionChoiceBox(vararg styleClass: String, id: String? = null):
    PrefixSelectionChoiceBox<T> = styledPrefixSelectionChoiceBox(
    styleClass = *styleClass,
    id =
    id
) { }

/**
 * Add a styled [PrefixSelectionChoiceBox] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun <T> NodeManager.styledPrefixSelectionChoiceBox(
    vararg styleClass: String,
    id: String? =    
        null
): PrefixSelectionChoiceBox<T> = styledPrefixSelectionChoiceBox(
    styleClass =
    *styleClass,
    id = id
) { }

/**
 * Create a styled [PrefixSelectionChoiceBox] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun <T> styledPrefixSelectionChoiceBox(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PrefixSelectionChoiceBox<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [PrefixSelectionChoiceBox] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun <T> NodeManager.styledPrefixSelectionChoiceBox(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PrefixSelectionChoiceBox<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
