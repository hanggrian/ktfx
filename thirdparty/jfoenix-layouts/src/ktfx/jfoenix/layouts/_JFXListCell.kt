@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListCell
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXListCell] to this manager.
 *
 * @return the control added.
 */
public fun <T> NodeManager.jfxListCell(): JFXListCell<T> = jfxListCell() { }

/**
 * Create a [JFXListCell] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun <T> jfxListCell(configuration: (@KtfxLayoutDslMarker JFXListCell<T>).() -> Unit):
    JFXListCell<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXListCell<T>()
    child.configuration()
    return child
}

/**
 * Add a [JFXListCell] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun <T> NodeManager.jfxListCell(
    configuration: (
        @KtfxLayoutDslMarker
        JFXListCell<T>
    ).() -> Unit
): JFXListCell<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXListCell<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXListCell].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun <T> styledJFXListCell(vararg styleClass: String, id: String? = null): JFXListCell<T> =
    styledJFXListCell(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXListCell] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun <T> NodeManager.styledJFXListCell(vararg styleClass: String, id: String? = null):
    JFXListCell<T> = styledJFXListCell(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXListCell] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun <T> styledJFXListCell(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXListCell<T>).() -> Unit
): JFXListCell<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXListCell<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXListCell] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun <T> NodeManager.styledJFXListCell(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXListCell<T>).() -> Unit
): JFXListCell<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXListCell<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
