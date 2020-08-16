@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.RangeSlider
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [RangeSlider] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75
): RangeSlider = rangeSlider(min = min, max = max, lowValue = lowValue, highValue = highValue) { }

/**
 * Create a [RangeSlider] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    configuration: (@LayoutDslMarker RangeSlider).() -> Unit
): RangeSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RangeSlider(min, max, lowValue, highValue)
    child.configuration()
    return child
}

/**
 * Add a [RangeSlider] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    configuration: (@LayoutDslMarker RangeSlider).() -> Unit
): RangeSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RangeSlider(min, max, lowValue, highValue)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [RangeSlider].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledRangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    vararg styleClass: String,
    id: String? = null
): RangeSlider = styledRangeSlider(
    min = min, max = max, lowValue = lowValue, highValue = highValue,
    styleClass = *styleClass, id = id
) { }

/**
 * Add a styled [RangeSlider] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledRangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    vararg styleClass: String,
    id: String? = null
): RangeSlider = styledRangeSlider(
    min = min, max = max, lowValue = lowValue, highValue = highValue,
    styleClass = *styleClass, id = id
) { }

/**
 * Create a styled [RangeSlider] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledRangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker RangeSlider).() -> Unit
): RangeSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RangeSlider(min, max, lowValue, highValue)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [RangeSlider] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledRangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker RangeSlider).() -> Unit
): RangeSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RangeSlider(min, max, lowValue, highValue)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
