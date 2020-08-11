@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.PasswordField
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [PasswordField] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.passwordField(): PasswordField = passwordField() { }

/**
 * Create a [PasswordField] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun passwordField(configuration: (@LayoutDslMarker PasswordField).() -> Unit):
    PasswordField {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(PasswordField(), configuration = configuration)
}

/**
 * Add a [PasswordField] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.passwordField(configuration: (@LayoutDslMarker PasswordField).() -> Unit):
    PasswordField {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(PasswordField(), configuration = configuration))
}

/**
 * Create a styled [PasswordField].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledPasswordField(vararg styleClass: String, id: String? = null): PasswordField =
    styledPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [PasswordField] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledPasswordField(vararg styleClass: String, id: String? = null): PasswordField =
    styledPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [PasswordField] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledPasswordField(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker PasswordField).() -> Unit
): PasswordField {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(PasswordField(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [PasswordField] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledPasswordField(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker PasswordField).() -> Unit
): PasswordField {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(PasswordField(), styleClass = *styleClass, id = id, configuration =
      configuration))
}
