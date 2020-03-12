@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXPasswordField
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
 * Add a [JFXPasswordField] to this manager.
 */
fun NodeManager.jfxPasswordField(): JFXPasswordField = jfxPasswordField() { }

/**
 * Create a [JFXPasswordField] with configuration block.
 */
inline fun jfxPasswordField(configuration: (@LayoutDslMarker JFXPasswordField).() -> Unit):
        JFXPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXPasswordField(), configuration = configuration)
}

/**
 * Add a [JFXPasswordField] with configuration block to this manager.
 */
inline fun NodeManager.jfxPasswordField(
    configuration: (@LayoutDslMarker JFXPasswordField).() ->
Unit
): JFXPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXPasswordField(), configuration = configuration))
}

/**
 * Create a styled [JFXPasswordField].
 */
fun styledJFXPasswordField(vararg styleClass: String, id: String? = null): JFXPasswordField =
        styledJFXPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXPasswordField] to this manager.
 */
fun NodeManager.styledJFXPasswordField(vararg styleClass: String, id: String? = null):
        JFXPasswordField = styledJFXPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXPasswordField] with configuration block.
 */
inline fun styledJFXPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXPasswordField).() -> Unit
): JFXPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXPasswordField(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXPasswordField] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXPasswordField).() -> Unit
): JFXPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXPasswordField(), styleClass = *styleClass, id = id, configuration =
            configuration))
}
