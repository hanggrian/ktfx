@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Label
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Label] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.label(text: String? = null, graphic: Node? = null): Label = label(text = text,
    graphic = graphic) { }

/**
 * Create a [Label] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun label(
  text: String? = null,
  graphic: Node? = null,
  configuration: (@LayoutDslMarker Label).() -> Unit
): Label {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Label(text, graphic), configuration = configuration)
}

/**
 * Add a [Label] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.label(
  text: String? = null,
  graphic: Node? = null,
  configuration: (@LayoutDslMarker Label).() -> Unit
): Label {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Label(text, graphic), configuration = configuration))
}

/**
 * Create a styled [Label].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledLabel(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): Label = styledLabel(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Label] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledLabel(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): Label = styledLabel(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Label] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledLabel(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Label).() -> Unit
): Label {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Label(text, graphic), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [Label] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledLabel(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Label).() -> Unit
): Label {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Label(text, graphic), styleClass = *styleClass, id = id, configuration =
      configuration))
}
