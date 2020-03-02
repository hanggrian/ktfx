@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

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
 */
fun NodeManager.passwordField(): PasswordField = passwordField() { }

/**
 * Create a [PasswordField] with configuration block.
 */
inline fun passwordField(configuration: (@LayoutDslMarker PasswordField).() -> Unit):
        PasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(PasswordField(), configuration = configuration)
}

/**
 * Add a [PasswordField] with configuration block to this manager.
 */
inline fun NodeManager.passwordField(configuration: (@LayoutDslMarker PasswordField).() -> Unit):
        PasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(PasswordField(), configuration = configuration))
}

/**
 * Create a styled [PasswordField].
 */
fun styledPasswordField(vararg styleClass: String): PasswordField = styledPasswordField(styleClass =
        *styleClass) { }

/**
 * Add a styled [PasswordField] to this manager.
 */
fun NodeManager.styledPasswordField(vararg styleClass: String): PasswordField =
        styledPasswordField(styleClass = *styleClass) { }

/**
 * Create a styled [PasswordField] with configuration block.
 */
inline fun styledPasswordField(
    vararg styleClass: String,
    configuration: (@LayoutDslMarker    
            PasswordField).() -> Unit
): PasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(PasswordField(), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [PasswordField] with configuration block to this manager.
 */
inline fun NodeManager.styledPasswordField(
    vararg styleClass: String,
    configuration: (@LayoutDslMarker PasswordField).() -> Unit
): PasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(PasswordField(), styleClass = *styleClass, configuration =
            configuration))
}
