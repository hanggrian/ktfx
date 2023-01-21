@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeCell
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
 * Add a [JFXTreeCell] to this manager.
 *
 * @return the control added.
 */
public fun <T> NodeManager.jfxTreeCell(): JFXTreeCell<T> = jfxTreeCell() { }

/**
 * Create a [JFXTreeCell] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun <T> jfxTreeCell(configuration: (@KtfxLayoutDslMarker JFXTreeCell<T>).() -> Unit):
        JFXTreeCell<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeCell<T>()
    child.configuration()
    return child
}

/**
 * Add a [JFXTreeCell] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun <T> NodeManager.jfxTreeCell(configuration: (@KtfxLayoutDslMarker
        JFXTreeCell<T>).() -> Unit): JFXTreeCell<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeCell<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTreeCell].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun <T> styledJFXTreeCell(vararg styleClass: String, id: String? = null): JFXTreeCell<T> =
        styledJFXTreeCell(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTreeCell] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun <T> NodeManager.styledJFXTreeCell(vararg styleClass: String, id: String? = null):
        JFXTreeCell<T> = styledJFXTreeCell(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTreeCell] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun <T> styledJFXTreeCell(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeCell<T>).() -> Unit,
): JFXTreeCell<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeCell<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTreeCell] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun <T> NodeManager.styledJFXTreeCell(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeCell<T>).() -> Unit,
): JFXTreeCell<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeCell<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
