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
import org.controlsfx.control.textfield.CustomTextField

/**
 * Add a [CustomTextField] to this manager.
 */
fun NodeManager.customTextField(): CustomTextField = customTextField() { }

/**
 * Create a [CustomTextField] with configuration block.
 */
inline fun customTextField(configuration: (@LayoutDslMarker CustomTextField).() -> Unit):
        CustomTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CustomTextField(), configuration = configuration)
}

/**
 * Add a [CustomTextField] with configuration block to this manager.
 */
inline fun NodeManager.customTextField(
    configuration: (@LayoutDslMarker CustomTextField).() ->
Unit
): CustomTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CustomTextField(), configuration = configuration))
}

/**
 * Create a styled [CustomTextField].
 */
fun styledCustomTextField(vararg styleClass: String, id: String? = null): CustomTextField =
        styledCustomTextField(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CustomTextField] to this manager.
 */
fun NodeManager.styledCustomTextField(vararg styleClass: String, id: String? = null):
        CustomTextField = styledCustomTextField(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CustomTextField] with configuration block.
 */
inline fun styledCustomTextField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CustomTextField).() -> Unit
): CustomTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CustomTextField(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [CustomTextField] with configuration block to this manager.
 */
inline fun NodeManager.styledCustomTextField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CustomTextField).() -> Unit
): CustomTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CustomTextField(), styleClass = *styleClass, id = id, configuration =
            configuration))
}
