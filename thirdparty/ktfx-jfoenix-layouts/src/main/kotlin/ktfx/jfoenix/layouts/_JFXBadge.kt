@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXBadge
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
 * Add a [JFXBadge] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxBadge(): JFXBadge = jfxBadge() { }

/**
 * Create a [JFXBadge] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun jfxBadge(configuration: (@KtfxLayoutDslMarker KtfxJfxBadge).() -> Unit): JFXBadge {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxBadge()
    child.configuration()
    return child
}

/**
 * Add a [JFXBadge] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun NodeContainer.jfxBadge(configuration: (@KtfxLayoutDslMarker KtfxJfxBadge).() -> Unit):
        JFXBadge {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxBadge()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXBadge].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledJfxBadge(vararg styleClass: String, id: String? = null): JFXBadge =
        styledJfxBadge(styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXBadge] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxBadge(vararg styleClass: String, id: String? = null):
        JFXBadge = styledJfxBadge(styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXBadge] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun styledJfxBadge(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxBadge).() -> Unit,
): JFXBadge {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxBadge()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXBadge] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun NodeContainer.styledJfxBadge(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxBadge).() -> Unit,
): JFXBadge {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxBadge()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
