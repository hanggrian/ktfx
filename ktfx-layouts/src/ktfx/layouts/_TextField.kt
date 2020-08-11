@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TextField
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [TextField] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.textField(text: String = ""): TextField = textField(text = text) { }

/**
 * Create a [TextField] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun textField(text: String = "", configuration: (@LayoutDslMarker TextField).() -> Unit):
    TextField {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(TextField(text), configuration = configuration)
}

/**
 * Add a [TextField] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.textField(text: String = "", configuration: (@LayoutDslMarker
    TextField).() -> Unit): TextField {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(TextField(text), configuration = configuration))
}

/**
 * Create a styled [TextField].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledTextField(
  text: String = "",
  vararg styleClass: String,
  id: String? = null
): TextField = styledTextField(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TextField] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledTextField(
  text: String = "",
  vararg styleClass: String,
  id: String? = null
): TextField = styledTextField(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TextField] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledTextField(
  text: String = "",
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker TextField).() -> Unit
): TextField {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(TextField(text), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [TextField] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledTextField(
  text: String = "",
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker TextField).() -> Unit
): TextField {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(TextField(text), styleClass = *styleClass, id = id, configuration =
      configuration))
}
