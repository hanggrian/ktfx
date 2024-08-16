@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.control.Slider
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Slider] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.slider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 0.0,
): Slider = slider(min = min, max = max, value = value) { }

/**
 * Create a [Slider] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun slider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Slider).() -> Unit,
): Slider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Slider(min, max, value)
    child.configuration()
    return child
}

/**
 * Add a [Slider] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.slider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Slider).() -> Unit,
): Slider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Slider(min, max, value)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Slider].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Slider = styledSlider(min = min, max = max, value = value, styleClass = styleClass, id = id) { }

/**
 * Add a styled [Slider] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Slider = styledSlider(min = min, max = max, value = value, styleClass = styleClass, id = id) { }

/**
 * Create a styled [Slider] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Slider).() -> Unit,
): Slider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Slider(min, max, value)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Slider] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Slider).() -> Unit,
): Slider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Slider(min, max, value)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
