@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListView
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer

/**
 * Add a [JFXListView] to this container.
 *
 * @return the control added.
 */
public fun <T> NodeContainer.jfxListView(): JFXListView<T> = jfxListView() { }

/**
 * Create a [JFXListView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun <T> jfxListView(configuration: (@KtfxLayoutDslMarker JFXListView<T>).() -> Unit):
        JFXListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXListView<T>()
    child.configuration()
    return child
}

/**
 * Add a [JFXListView] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun <T> NodeContainer.jfxListView(configuration: (@KtfxLayoutDslMarker
        JFXListView<T>).() -> Unit): JFXListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXListView<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXListView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun <T> styledJFXListView(vararg styleClass: String, id: String? = null): JFXListView<T> =
        styledJFXListView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXListView] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun <T> NodeContainer.styledJFXListView(vararg styleClass: String, id: String? = null):
        JFXListView<T> = styledJFXListView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXListView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun <T> styledJFXListView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXListView<T>).() -> Unit,
): JFXListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXListView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXListView] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledJFXListView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXListView<T>).() -> Unit,
): JFXListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXListView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
