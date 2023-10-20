@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.ScrollBar
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
 * Add a [ScrollBar] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.scrollBar(): ScrollBar = scrollBar() { }

/**
 * Create a [ScrollBar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun scrollBar(configuration: (@KtfxLayoutDslMarker ScrollBar).() -> Unit): ScrollBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ScrollBar()
    child.configuration()
    return child
}

/**
 * Add a [ScrollBar] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.scrollBar(configuration: (@KtfxLayoutDslMarker
        ScrollBar).() -> Unit): ScrollBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ScrollBar()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ScrollBar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledScrollBar(vararg styleClass: String, id: String? = null): ScrollBar =
        styledScrollBar(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ScrollBar] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledScrollBar(vararg styleClass: String, id: String? = null): ScrollBar =
        styledScrollBar(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ScrollBar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledScrollBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ScrollBar).() -> Unit,
): ScrollBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ScrollBar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ScrollBar] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledScrollBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ScrollBar).() -> Unit,
): ScrollBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ScrollBar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
