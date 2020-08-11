@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

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
 * Add a [Slider] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.slider(
  min: Double = 0.0,
  max: Double = 100.0,
  value: Double = 0.0
): Slider = slider(min = min, max = max, value = value) { }

/**
 * Create a [Slider] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
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
 * @param configuration the configuration block.
 *
 * @return the control added.
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

/**
 * Create a styled [Slider].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledSlider(
  min: Double = 0.0,
  max: Double = 100.0,
  value: Double = 0.0,
  vararg styleClass: String,
  id: String? = null
): Slider = styledSlider(min = min, max = max, value = value, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Slider] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledSlider(
  min: Double = 0.0,
  max: Double = 100.0,
  value: Double = 0.0,
  vararg styleClass: String,
  id: String? = null
): Slider = styledSlider(min = min, max = max, value = value, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Slider] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledSlider(
  min: Double = 0.0,
  max: Double = 100.0,
  value: Double = 0.0,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Slider).() -> Unit
): Slider {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Slider(min, max, value), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [Slider] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledSlider(
  min: Double = 0.0,
  max: Double = 100.0,
  value: Double = 0.0,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Slider).() -> Unit
): Slider {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Slider(min, max, value), styleClass = *styleClass, id = id, configuration
      = configuration))
}
