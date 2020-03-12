@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

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
import org.controlsfx.control.textfield.CustomPasswordField

/**
 * Add a [CustomPasswordField] to this manager.
 */
fun NodeManager.customPasswordField(): CustomPasswordField = customPasswordField() { }

/**
 * Create a [CustomPasswordField] with configuration block.
 */
inline fun customPasswordField(configuration: (@LayoutDslMarker CustomPasswordField).() -> Unit):
        CustomPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CustomPasswordField(), configuration = configuration)
}

/**
 * Add a [CustomPasswordField] with configuration block to this manager.
 */
inline fun NodeManager.customPasswordField(
    configuration: (@LayoutDslMarker
CustomPasswordField).() -> Unit
): CustomPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CustomPasswordField(), configuration = configuration))
}

/**
 * Create a styled [CustomPasswordField].
 */
fun styledCustomPasswordField(vararg styleClass: String, id: String? = null): CustomPasswordField =
        styledCustomPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CustomPasswordField] to this manager.
 */
fun NodeManager.styledCustomPasswordField(vararg styleClass: String, id: String? = null):
        CustomPasswordField = styledCustomPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CustomPasswordField] with configuration block.
 */
inline fun styledCustomPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CustomPasswordField).() -> Unit
): CustomPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CustomPasswordField(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [CustomPasswordField] with configuration block to this manager.
 */
inline fun NodeManager.styledCustomPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CustomPasswordField).() -> Unit
): CustomPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CustomPasswordField(), styleClass = *styleClass, id = id, configuration =
            configuration))
}
