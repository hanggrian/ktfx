@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.layout.Pane
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Pane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.pane(): Pane = pane() { }

/**
 * Create a [Pane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun pane(configuration: (@KtfxLayoutDslMarker KtfxPane).() -> Unit): Pane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxPane()
    child.configuration()
    return child
}

/**
 * Add a [Pane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.pane(configuration: (@KtfxLayoutDslMarker KtfxPane).() -> Unit):
        Pane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Pane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledPane(vararg styleClass: String, id: String? = null): Pane = styledPane(styleClass =
        *styleClass, id = id) { }

/**
 * Add a styled [Pane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledPane(vararg styleClass: String, id: String? = null): Pane =
        styledPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Pane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxPane).() -> Unit,
): Pane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Pane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxPane).() -> Unit,
): Pane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
