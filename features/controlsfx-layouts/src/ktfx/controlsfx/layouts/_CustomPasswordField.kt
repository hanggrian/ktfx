@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.textfield.CustomPasswordField
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CustomPasswordField] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.customPasswordField(): CustomPasswordField = customPasswordField() { }

/**
 * Create a [CustomPasswordField] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun customPasswordField(configuration: (@LayoutDslMarker CustomPasswordField).() -> Unit):
    CustomPasswordField {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = CustomPasswordField()
        child.configuration()
        return child
    }

/**
 * Add a [CustomPasswordField] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.customPasswordField(
    configuration: (
        @LayoutDslMarker
        CustomPasswordField
    ).() -> Unit
): CustomPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomPasswordField()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [CustomPasswordField].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledCustomPasswordField(vararg styleClass: String, id: String? = null): CustomPasswordField =
    styledCustomPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CustomPasswordField] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledCustomPasswordField(vararg styleClass: String, id: String? = null):
    CustomPasswordField = styledCustomPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CustomPasswordField] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledCustomPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CustomPasswordField).() -> Unit
): CustomPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomPasswordField()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [CustomPasswordField] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledCustomPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CustomPasswordField).() -> Unit
): CustomPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomPasswordField()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
