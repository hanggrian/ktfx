@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSlider
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXSlider] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0
): JFXSlider = jfxSlider(min = min, max = max, value = value) { }

/**
 * Create a [JFXSlider] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    configuration: (@LayoutDslMarker JFXSlider).() -> Unit
): JFXSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXSlider(min, max, value)
    child.configuration()
    return child
}

/**
 * Add a [JFXSlider] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    configuration: (@LayoutDslMarker JFXSlider).() -> Unit
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
fun styledJFXSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    vararg styleClass: String,
    id: String? = null
): JFXSlider = styledJFXSlider(
    min = min, max = max, value = value, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Add a styled [JFXSlider] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledJFXSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    vararg styleClass: String,
    id: String? = null
): JFXSlider = styledJFXSlider(
    min = min, max = max, value = value, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Create a styled [JFXSlider] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledJFXSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXSlider).() -> Unit
): JFXSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXSlider(min, max, value)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXSlider] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXSlider).() -> Unit
): JFXSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXSlider(min, max, value)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
