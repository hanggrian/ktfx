@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer
import org.controlsfx.control.textfield.CustomPasswordField

/**
 * Add a [CustomPasswordField] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.customPasswordField(): CustomPasswordField = customPasswordField() { }

/**
 * Create a [CustomPasswordField] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun customPasswordField(configuration: (@KtfxLayoutDslMarker
        CustomPasswordField).() -> Unit): CustomPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomPasswordField()
    child.configuration()
    return child
}

/**
 * Add a [CustomPasswordField] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.customPasswordField(configuration: (@KtfxLayoutDslMarker
        CustomPasswordField).() -> Unit): CustomPasswordField {
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
public fun styledCustomPasswordField(vararg styleClass: String, id: String? = null):
        CustomPasswordField = styledCustomPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CustomPasswordField] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledCustomPasswordField(vararg styleClass: String, id: String? = null):
        CustomPasswordField = styledCustomPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CustomPasswordField] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledCustomPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CustomPasswordField).() -> Unit,
): CustomPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomPasswordField()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [CustomPasswordField] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledCustomPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CustomPasswordField).() -> Unit,
): CustomPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomPasswordField()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
