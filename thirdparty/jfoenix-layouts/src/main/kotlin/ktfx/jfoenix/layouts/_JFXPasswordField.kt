@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXPasswordField
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
import ktfx.layouts.NodeManager

/**
 * Add a [JFXPasswordField] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.jfxPasswordField(): JFXPasswordField = jfxPasswordField() { }

/**
 * Create a [JFXPasswordField] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxPasswordField(configuration: (@KtfxLayoutDslMarker
        JFXPasswordField).() -> Unit): JFXPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXPasswordField()
    child.configuration()
    return child
}

/**
 * Add a [JFXPasswordField] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.jfxPasswordField(configuration: (@KtfxLayoutDslMarker
        JFXPasswordField).() -> Unit): JFXPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXPasswordField()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXPasswordField].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledJFXPasswordField(vararg styleClass: String, id: String? = null): JFXPasswordField =
        styledJFXPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXPasswordField] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledJFXPasswordField(vararg styleClass: String, id: String? = null):
        JFXPasswordField = styledJFXPasswordField(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXPasswordField] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJFXPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXPasswordField).() -> Unit,
): JFXPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXPasswordField()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXPasswordField] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledJFXPasswordField(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXPasswordField).() -> Unit,
): JFXPasswordField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXPasswordField()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
