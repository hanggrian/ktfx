@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTabPane
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
 * Add a [JFXTabPane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.jfxTabPane(): JFXTabPane = jfxTabPane() { }

/**
 * Create a [JFXTabPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxTabPane(configuration: (@KtfxLayoutDslMarker KtfxJfxTabPane).() -> Unit):
        JFXTabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxTabPane()
    child.configuration()
    return child
}

/**
 * Add a [JFXTabPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.jfxTabPane(configuration: (@KtfxLayoutDslMarker
        KtfxJfxTabPane).() -> Unit): JFXTabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxTabPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTabPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledJFXTabPane(vararg styleClass: String, id: String? = null): JFXTabPane =
        styledJFXTabPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTabPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledJFXTabPane(vararg styleClass: String, id: String? = null): JFXTabPane =
        styledJFXTabPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTabPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJFXTabPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxTabPane).() -> Unit,
): JFXTabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxTabPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTabPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledJFXTabPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxTabPane).() -> Unit,
): JFXTabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxTabPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
