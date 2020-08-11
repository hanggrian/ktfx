@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.text.TextFlow
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [TextFlow] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.textFlow(): TextFlow = textFlow() { }

/**
 * Create a [TextFlow] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun textFlow(configuration: (@LayoutDslMarker KtfxTextFlow).() -> Unit): TextFlow {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxTextFlow(), configuration = configuration)
}

/**
 * Add a [TextFlow] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.textFlow(configuration: (@LayoutDslMarker KtfxTextFlow).() -> Unit):
    TextFlow {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxTextFlow(), configuration = configuration))
}

/**
 * Create a styled [TextFlow].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledTextFlow(vararg styleClass: String, id: String? = null): TextFlow =
    styledTextFlow(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TextFlow] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledTextFlow(vararg styleClass: String, id: String? = null): TextFlow =
    styledTextFlow(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TextFlow] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledTextFlow(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxTextFlow).() -> Unit
): TextFlow {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(KtfxTextFlow(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [TextFlow] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledTextFlow(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker KtfxTextFlow).() -> Unit
): TextFlow {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(KtfxTextFlow(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
