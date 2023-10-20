@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.layouts

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
import ktfx.layouts.NodeContainer
import org.controlsfx.control.StatusBar

/**
 * Add a [StatusBar] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.statusBar(): StatusBar = statusBar() { }

/**
 * Create a [StatusBar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun statusBar(configuration: (@KtfxLayoutDslMarker StatusBar).() -> Unit): StatusBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StatusBar()
    child.configuration()
    return child
}

/**
 * Add a [StatusBar] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.statusBar(configuration: (@KtfxLayoutDslMarker
        StatusBar).() -> Unit): StatusBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StatusBar()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [StatusBar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledStatusBar(vararg styleClass: String, id: String? = null): StatusBar =
        styledStatusBar(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [StatusBar] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledStatusBar(vararg styleClass: String, id: String? = null): StatusBar =
        styledStatusBar(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [StatusBar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledStatusBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker StatusBar).() -> Unit,
): StatusBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StatusBar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [StatusBar] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledStatusBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker StatusBar).() -> Unit,
): StatusBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = StatusBar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
