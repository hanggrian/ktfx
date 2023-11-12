@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.PasswordField
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [PasswordField] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.passwordField(): PasswordField = passwordField() { }

/**
 * Create a [PasswordField] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun passwordField(configuration: (@KtfxLayoutDslMarker PasswordField).() -> Unit):
        PasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PasswordField()
    child.configuration()
    return child
}

/**
 * Add a [PasswordField] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.passwordField(configuration: (@KtfxLayoutDslMarker
        PasswordField).() -> Unit): PasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PasswordField()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [PasswordField].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledPasswordField(vararg styleClass: String, id: String? = null): PasswordField =
        styledPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [PasswordField] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledPasswordField(vararg styleClass: String, id: String? = null):
        PasswordField = styledPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [PasswordField] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PasswordField).() -> Unit,
): PasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PasswordField()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [PasswordField] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker PasswordField).() -> Unit,
): PasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = PasswordField()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
