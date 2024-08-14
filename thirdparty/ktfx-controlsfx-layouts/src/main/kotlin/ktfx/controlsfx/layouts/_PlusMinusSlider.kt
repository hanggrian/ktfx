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
import org.controlsfx.control.PlusMinusSlider

/**
 * Add a [PlusMinusSlider] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.plusMinusSlider(): PlusMinusSlider = plusMinusSlider() { }

/**
 * Create a [PlusMinusSlider] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun plusMinusSlider(configuration: (@KtfxLayoutDslMarker PlusMinusSlider).() -> Unit):
        PlusMinusSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PlusMinusSlider()
    child.configuration()
    return child
}

/**
 * Add a [PlusMinusSlider] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun NodeContainer.plusMinusSlider(configuration: (@KtfxLayoutDslMarker
        PlusMinusSlider).() -> Unit): PlusMinusSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PlusMinusSlider()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [PlusMinusSlider].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledPlusMinusSlider(vararg styleClass: String, id: String? = null):
        PlusMinusSlider = styledPlusMinusSlider(styleClass = styleClass, id = id) { }

/**
 * Add a styled [PlusMinusSlider] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledPlusMinusSlider(vararg styleClass: String, id: String? =
        null): PlusMinusSlider = styledPlusMinusSlider(styleClass = styleClass, id = id) { }

/**
 * Create a styled [PlusMinusSlider] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun styledPlusMinusSlider(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PlusMinusSlider).() -> Unit,
): PlusMinusSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PlusMinusSlider()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [PlusMinusSlider] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun NodeContainer.styledPlusMinusSlider(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PlusMinusSlider).() -> Unit,
): PlusMinusSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PlusMinusSlider()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
