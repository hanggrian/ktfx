@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToggleNode
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
import ktfx.layouts.ToggleButtonManager

/**
 * Add a [JFXToggleNode] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxToggleNode(graphic: Node? = null): JFXToggleNode = jfxToggleNode(graphic =
    graphic) { }

/**
 * Add a [JFXToggleNode] to this manager.
 *
 * @return the control added.
 */
fun ToggleButtonManager.jfxToggleNode(graphic: Node? = null): JFXToggleNode = jfxToggleNode(graphic
    = graphic) { }

/**
 * Create a [JFXToggleNode] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxToggleNode(graphic: Node? = null, configuration: (@LayoutDslMarker
    JFXToggleNode).() -> Unit): JFXToggleNode {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXToggleNode(graphic), configuration = configuration)
}

/**
 * Add a [JFXToggleNode] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxToggleNode(graphic: Node? = null, configuration: (@LayoutDslMarker
    JFXToggleNode).() -> Unit): JFXToggleNode {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXToggleNode(graphic), configuration = configuration))
}

/**
 * Add a [JFXToggleNode] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun ToggleButtonManager.jfxToggleNode(graphic: Node? = null, configuration: (@LayoutDslMarker
    JFXToggleNode).() -> Unit): JFXToggleNode {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXToggleNode(graphic), configuration = configuration))
}

/**
 * Create a styled [JFXToggleNode].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledJFXToggleNode(
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): JFXToggleNode = styledJFXToggleNode(graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXToggleNode] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledJFXToggleNode(
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): JFXToggleNode = styledJFXToggleNode(graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXToggleNode] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun ToggleButtonManager.styledJFXToggleNode(
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null
): JFXToggleNode = styledJFXToggleNode(graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXToggleNode] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledJFXToggleNode(
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXToggleNode).() -> Unit
): JFXToggleNode {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXToggleNode(graphic), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [JFXToggleNode] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXToggleNode(
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXToggleNode).() -> Unit
): JFXToggleNode {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXToggleNode(graphic), styleClass = *styleClass, id = id, configuration
      = configuration))
}

/**
 * Add a styled [JFXToggleNode] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun ToggleButtonManager.styledJFXToggleNode(
  graphic: Node? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXToggleNode).() -> Unit
): JFXToggleNode {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXToggleNode(graphic), styleClass = *styleClass, id = id, configuration
      = configuration))
}
