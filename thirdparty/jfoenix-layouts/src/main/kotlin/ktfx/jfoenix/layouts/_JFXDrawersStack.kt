@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawersStack
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
 * Add a [JFXDrawersStack] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.jfxDrawersStack(): JFXDrawersStack = jfxDrawersStack() { }

/**
 * Create a [JFXDrawersStack] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxDrawersStack(configuration: (@KtfxLayoutDslMarker JFXDrawersStack).() -> Unit):
        JFXDrawersStack {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDrawersStack()
    child.configuration()
    return child
}

/**
 * Add a [JFXDrawersStack] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.jfxDrawersStack(configuration: (@KtfxLayoutDslMarker
        JFXDrawersStack).() -> Unit): JFXDrawersStack {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDrawersStack()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXDrawersStack].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledJFXDrawersStack(vararg styleClass: String, id: String? = null): JFXDrawersStack =
        styledJFXDrawersStack(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXDrawersStack] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledJFXDrawersStack(vararg styleClass: String, id: String? = null):
        JFXDrawersStack = styledJFXDrawersStack(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXDrawersStack] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJFXDrawersStack(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXDrawersStack).() -> Unit,
): JFXDrawersStack {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDrawersStack()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXDrawersStack] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledJFXDrawersStack(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXDrawersStack).() -> Unit,
): JFXDrawersStack {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDrawersStack()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
