@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.Spinner
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Spinner] to this container.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.spinner(): Spinner<T> = spinner() { }

/**
 * Create a [Spinner] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun <T> spinner(configuration: (@KtfxLayoutDslMarker Spinner<T>).() -> Unit): Spinner<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Spinner<T>()
    child.configuration()
    return child
}

/**
 * Add a [Spinner] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun <T> NodeContainer.spinner(configuration: (@KtfxLayoutDslMarker Spinner<T>).() -> Unit):
        Spinner<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Spinner<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Spinner].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun <T> styledSpinner(vararg styleClass: String, id: String? = null): Spinner<T> =
        styledSpinner(styleClass = styleClass, id = id) { }

/**
 * Add a styled [Spinner] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledSpinner(vararg styleClass: String, id: String? = null):
        Spinner<T> = styledSpinner(styleClass = styleClass, id = id) { }

/**
 * Create a styled [Spinner] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun <T> styledSpinner(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Spinner<T>).() -> Unit,
): Spinner<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Spinner<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Spinner] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun <T> NodeContainer.styledSpinner(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Spinner<T>).() -> Unit,
): Spinner<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Spinner<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
