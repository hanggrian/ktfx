@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Slider
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Create a styled [Slider].
 */
fun styledSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    vararg styleClass: String
): Slider = styledSlider(min = min, max = max, value = value, styleClass = *styleClass) { }

/**
 * Add a styled [Slider] to this manager.
 */
fun NodeManager.styledSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    vararg styleClass: String
): Slider = styledSlider(min = min, max = max, value = value, styleClass = *styleClass) { }

/**
 * Create a styled [Slider] with configuration block.
 */
inline fun styledSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker Slider).() -> Unit
): Slider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Slider(min, max, value), styleClass = *styleClass, configuration =
            configuration)
}

/**
 * Add a styled [Slider] with configuration block to this manager.
 */
inline fun NodeManager.styledSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker Slider).() -> Unit
): Slider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Slider(min, max, value), styleClass = *styleClass, configuration =
            configuration))
}

/**
 * Add a [Slider] to this manager.
 */
fun NodeManager.slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0
): Slider = slider(min = min, max = max, value = value) { }

/**
 * Create a [Slider] with configuration block.
 */
inline fun slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    configuration: (@LayoutDslMarker Slider).() -> Unit
): Slider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Slider(min, max, value), configuration = configuration)
}

/**
 * Add a [Slider] with configuration block to this manager.
 */
inline fun NodeManager.slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    configuration: (@LayoutDslMarker Slider).() -> Unit
): Slider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Slider(min, max, value), configuration = configuration))
}
