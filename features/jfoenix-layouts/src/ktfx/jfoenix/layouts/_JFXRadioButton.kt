@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRadioButton
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.ToggleButtonManager

/**
 * Add a [JFXRadioButton] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxRadioButton(text: String? = null): JFXRadioButton = jfxRadioButton(text = text) {
    }

/**
 * Add a [JFXRadioButton] to this manager.
 *
 * @return the control added.
 */
fun ToggleButtonManager.jfxRadioButton(text: String? = null): JFXRadioButton = jfxRadioButton(text =
    text) { }

/**
 * Create a [JFXRadioButton] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxRadioButton(text: String? = null, configuration: (@LayoutDslMarker
    JFXRadioButton).() -> Unit): JFXRadioButton {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXRadioButton(text), configuration = configuration)
}

/**
 * Add a [JFXRadioButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxRadioButton(text: String? = null, configuration: (@LayoutDslMarker
    JFXRadioButton).() -> Unit): JFXRadioButton {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXRadioButton(text), configuration = configuration))
}

/**
 * Add a [JFXRadioButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun ToggleButtonManager.jfxRadioButton(text: String? = null, configuration: (@LayoutDslMarker
    JFXRadioButton).() -> Unit): JFXRadioButton {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXRadioButton(text), configuration = configuration))
}

/**
 * Create a styled [JFXRadioButton].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledJFXRadioButton(
  text: String? = null,
  vararg styleClass: String,
  id: String? = null
): JFXRadioButton = styledJFXRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXRadioButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledJFXRadioButton(
  text: String? = null,
  vararg styleClass: String,
  id: String? = null
): JFXRadioButton = styledJFXRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXRadioButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun ToggleButtonManager.styledJFXRadioButton(
  text: String? = null,
  vararg styleClass: String,
  id: String? = null
): JFXRadioButton = styledJFXRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXRadioButton] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledJFXRadioButton(
  text: String? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXRadioButton(text), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [JFXRadioButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXRadioButton(
  text: String? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXRadioButton(text), styleClass = *styleClass, id = id, configuration =
      configuration))
}

/**
 * Add a styled [JFXRadioButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun ToggleButtonManager.styledJFXRadioButton(
  text: String? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXRadioButton(text), styleClass = *styleClass, id = id, configuration =
      configuration))
}
