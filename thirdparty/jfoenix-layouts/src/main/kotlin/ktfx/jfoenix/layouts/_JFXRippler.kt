@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRippler
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
 * Add a [JFXRippler] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.jfxRippler(): JFXRippler = jfxRippler() { }

/**
 * Create a [JFXRippler] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxRippler(configuration: (@KtfxLayoutDslMarker KtfxJfxRippler).() -> Unit):
        JFXRippler {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxRippler()
    child.configuration()
    return child
}

/**
 * Add a [JFXRippler] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.jfxRippler(configuration: (@KtfxLayoutDslMarker
        KtfxJfxRippler).() -> Unit): JFXRippler {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxRippler()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXRippler].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledJFXRippler(vararg styleClass: String, id: String? = null): JFXRippler =
        styledJFXRippler(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXRippler] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledJFXRippler(vararg styleClass: String, id: String? = null): JFXRippler =
        styledJFXRippler(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXRippler] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJFXRippler(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxRippler).() -> Unit,
): JFXRippler {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxRippler()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXRippler] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledJFXRippler(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxRippler).() -> Unit,
): JFXRippler {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxRippler()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
