@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXClippedPane
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
 * Add a [JFXClippedPane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.jfxClippedPane(): JFXClippedPane = jfxClippedPane() { }

/**
 * Create a [JFXClippedPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxClippedPane(configuration: (@KtfxLayoutDslMarker
        KtfxJfxClippedPane).() -> Unit): JFXClippedPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxClippedPane()
    child.configuration()
    return child
}

/**
 * Add a [JFXClippedPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.jfxClippedPane(configuration: (@KtfxLayoutDslMarker
        KtfxJfxClippedPane).() -> Unit): JFXClippedPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxClippedPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXClippedPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledJFXClippedPane(vararg styleClass: String, id: String? = null): JFXClippedPane =
        styledJFXClippedPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXClippedPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledJFXClippedPane(vararg styleClass: String, id: String? = null):
        JFXClippedPane = styledJFXClippedPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXClippedPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJFXClippedPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxClippedPane).() -> Unit,
): JFXClippedPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxClippedPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXClippedPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledJFXClippedPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxClippedPane).() -> Unit,
): JFXClippedPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxClippedPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
