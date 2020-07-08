@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.internal.KtfxInternals.newChild
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
 */
fun NodeManager.rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75
): RangeSlider = rangeSlider(min = min, max = max, lowValue = lowValue, highValue = highValue) { }

/**
 * Create a [RangeSlider] with configuration block.
 */
inline fun rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    configuration: (@LayoutDslMarker RangeSlider).() -> Unit
): RangeSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(RangeSlider(min, max, lowValue, highValue), configuration = configuration)
}

/**
 * Add a [RangeSlider] with configuration block to this manager.
 */
inline fun NodeManager.rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    configuration: (@LayoutDslMarker RangeSlider).() -> Unit
): RangeSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            RangeSlider(min, max, lowValue, highValue),
            configuration =
                configuration
        )
    )
}

/**
 * Create a styled [RangeSlider].
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
    return newChild(
        RangeSlider(min, max, lowValue, highValue), styleClass = *styleClass, id = id,
        configuration = configuration
    )
}

/**
 * Add a styled [RangeSlider] with configuration block to this manager.
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
    return addChild(
        newChild(
            RangeSlider(min, max, lowValue, highValue), styleClass = *styleClass,
            id = id, configuration = configuration
        )
    )
}
