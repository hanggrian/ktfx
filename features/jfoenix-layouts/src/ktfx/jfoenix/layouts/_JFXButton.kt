@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXButton
import javafx.scene.Node
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

/**
 * Add a [JFXButton] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxButton(text: String? = null, graphic: Node? = null): JFXButton = jfxButton(text =
    text, graphic = graphic) { }

/**
 * Create a [JFXButton] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxButton(
  text: String? = null,
  graphic: Node? = null,
  configuration: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXButton(text, graphic), configuration = configuration)
}

/**
 * Add a [JFXButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxButton(
  text: String? = null,
  graphic: Node? = null,
  configuration: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXButton(text, graphic), configuration = configuration))
}

/**
 * Create a styled [JFXButton].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledJFXButton(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): JFXButton = styledJFXButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) {
    }

/**
 * Add a styled [JFXButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledJFXButton(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): JFXButton = styledJFXButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) {
    }

/**
 * Create a styled [JFXButton] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledJFXButton(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXButton(text, graphic), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [JFXButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXButton(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXButton(text, graphic), styleClass = *styleClass, id = id,
      configuration = configuration))
}
