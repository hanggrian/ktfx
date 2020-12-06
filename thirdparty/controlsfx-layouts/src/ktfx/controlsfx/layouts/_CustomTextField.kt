@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.textfield.CustomTextField
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CustomTextField] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.customTextField(): CustomTextField = customTextField() { }

/**
 * Create a [CustomTextField] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun customTextField(configuration: (@KtfxLayoutDslMarker CustomTextField).() -> Unit):
    CustomTextField {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = CustomTextField()
        child.configuration()
        return child
    }

/**
 * Add a [CustomTextField] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.customTextField(
    configuration: (
        @KtfxLayoutDslMarker
        CustomTextField
    ).() -> Unit
): CustomTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomTextField()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [CustomTextField].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledCustomTextField(vararg styleClass: String, id: String? = null): CustomTextField =
    styledCustomTextField(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CustomTextField] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledCustomTextField(vararg styleClass: String, id: String? = null):
    CustomTextField = styledCustomTextField(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CustomTextField] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledCustomTextField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CustomTextField).() -> Unit
): CustomTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomTextField()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [CustomTextField] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledCustomTextField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CustomTextField).() -> Unit
): CustomTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomTextField()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
