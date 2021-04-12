@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PlusMinusSlider
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [PlusMinusSlider] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.plusMinusSlider(): PlusMinusSlider = plusMinusSlider() { }

/**
 * Create a [PlusMinusSlider] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun plusMinusSlider(configuration: (@KtfxLayoutDslMarker PlusMinusSlider).() -> Unit):
    PlusMinusSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PlusMinusSlider()
    child.configuration()
    return child
}

/**
 * Add a [PlusMinusSlider] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.plusMinusSlider(
    configuration: (
        @KtfxLayoutDslMarker
        PlusMinusSlider
    ).() -> Unit
): PlusMinusSlider {
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
public fun styledPlusMinusSlider(vararg styleClass: String, id: String? = null): PlusMinusSlider =
    styledPlusMinusSlider(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [PlusMinusSlider] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledPlusMinusSlider(vararg styleClass: String, id: String? = null):
    PlusMinusSlider = styledPlusMinusSlider(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [PlusMinusSlider] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledPlusMinusSlider(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PlusMinusSlider).() -> Unit
): PlusMinusSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PlusMinusSlider()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [PlusMinusSlider] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledPlusMinusSlider(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PlusMinusSlider).() -> Unit
): PlusMinusSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PlusMinusSlider()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
