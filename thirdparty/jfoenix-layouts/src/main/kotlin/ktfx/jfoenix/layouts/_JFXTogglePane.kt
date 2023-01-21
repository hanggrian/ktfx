@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTogglePane
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager

/**
 * Add a [JFXTogglePane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.jfxTogglePane(): JFXTogglePane = jfxTogglePane() { }

/**
 * Create a [JFXTogglePane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxTogglePane(configuration: (@KtfxLayoutDslMarker KtfxJfxTogglePane).() -> Unit):
        JFXTogglePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxTogglePane()
    child.configuration()
    return child
}

/**
 * Add a [JFXTogglePane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.jfxTogglePane(configuration: (@KtfxLayoutDslMarker
        KtfxJfxTogglePane).() -> Unit): JFXTogglePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxTogglePane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTogglePane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledJFXTogglePane(vararg styleClass: String, id: String? = null): JFXTogglePane =
        styledJFXTogglePane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTogglePane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledJFXTogglePane(vararg styleClass: String, id: String? = null):
        JFXTogglePane = styledJFXTogglePane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTogglePane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJFXTogglePane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxTogglePane).() -> Unit,
): JFXTogglePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxTogglePane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTogglePane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledJFXTogglePane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxTogglePane).() -> Unit,
): JFXTogglePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxTogglePane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
