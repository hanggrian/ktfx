@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Hyperlink
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Hyperlink] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.hyperlink(text: String? = null, graphic: Node? = null): Hyperlink = hyperlink(text =
    text, graphic = graphic) { }

/**
 * Create a [Hyperlink] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun hyperlink(
  text: String? = null,
  graphic: Node? = null,
  configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Hyperlink(text, graphic), configuration = configuration)
}

/**
 * Add a [Hyperlink] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.hyperlink(
  text: String? = null,
  graphic: Node? = null,
  configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Hyperlink(text, graphic), configuration = configuration))
}

/**
 * Create a styled [Hyperlink].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledHyperlink(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): Hyperlink = styledHyperlink(text = text, graphic = graphic, styleClass = *styleClass, id = id) {
    }

/**
 * Add a styled [Hyperlink] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledHyperlink(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): Hyperlink = styledHyperlink(text = text, graphic = graphic, styleClass = *styleClass, id = id) {
    }

/**
 * Create a styled [Hyperlink] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledHyperlink(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Hyperlink(text, graphic), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [Hyperlink] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledHyperlink(
  text: String? = null,
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Hyperlink(text, graphic), styleClass = *styleClass, id = id,
      configuration = configuration))
}
