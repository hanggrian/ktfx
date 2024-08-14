@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXHamburger
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
 * Add a [JFXHamburger] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxHamburger(): JFXHamburger = jfxHamburger() { }

/**
 * Create a [JFXHamburger] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun jfxHamburger(configuration: (@KtfxLayoutDslMarker JFXHamburger).() -> Unit):
        JFXHamburger {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXHamburger()
    child.configuration()
    return child
}

/**
 * Add a [JFXHamburger] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun NodeContainer.jfxHamburger(configuration: (@KtfxLayoutDslMarker
        JFXHamburger).() -> Unit): JFXHamburger {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXHamburger()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXHamburger].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledJfxHamburger(vararg styleClass: String, id: String? = null): JFXHamburger =
        styledJfxHamburger(styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXHamburger] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxHamburger(vararg styleClass: String, id: String? = null):
        JFXHamburger = styledJfxHamburger(styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXHamburger] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun styledJfxHamburger(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXHamburger).() -> Unit,
): JFXHamburger {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXHamburger()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXHamburger] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun NodeContainer.styledJfxHamburger(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXHamburger).() -> Unit,
): JFXHamburger {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXHamburger()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
