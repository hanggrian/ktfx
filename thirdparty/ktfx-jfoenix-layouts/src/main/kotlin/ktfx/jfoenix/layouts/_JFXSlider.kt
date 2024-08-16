@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSlider
import kotlin.Double
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

/**
 * Add a [JFXSlider] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 50.0,
): JFXSlider = jfxSlider(min = min, max = max, value = value) { }

/**
 * Create a [JFXSlider] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 50.0,
    configuration: (@KtfxLayoutDslMarker JFXSlider).() -> Unit,
): JFXSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXSlider(min, max, value)
    child.configuration()
    return child
}

/**
 * Add a [JFXSlider] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 50.0,
    configuration: (@KtfxLayoutDslMarker JFXSlider).() -> Unit,
): JFXSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXSlider(min, max, value)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXSlider].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledJfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 50.0,
    vararg styleClass: String,
    id: String? = null,
): JFXSlider = styledJfxSlider(min = min, max = max, value = value, styleClass = styleClass, id =
        id) { }

/**
 * Add a styled [JFXSlider] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 50.0,
    vararg styleClass: String,
    id: String? = null,
): JFXSlider = styledJfxSlider(min = min, max = max, value = value, styleClass = styleClass, id =
        id) { }

/**
 * Create a styled [JFXSlider] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledJfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 50.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXSlider).() -> Unit,
): JFXSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXSlider(min, max, value)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXSlider] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    `value`: Double = 50.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXSlider).() -> Unit,
): JFXSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXSlider(min, max, value)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
