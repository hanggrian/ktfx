@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToolbar
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
 * Add a [JFXToolbar] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxToolbar(): JFXToolbar = jfxToolbar() { }

/**
 * Create a [JFXToolbar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun jfxToolbar(configuration: (@KtfxLayoutDslMarker KtfxJfxToolbar).() -> Unit): JFXToolbar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxToolbar()
    child.configuration()
    return child
}

/**
 * Add a [JFXToolbar] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun NodeContainer.jfxToolbar(configuration: (@KtfxLayoutDslMarker
        KtfxJfxToolbar).() -> Unit): JFXToolbar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxToolbar()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXToolbar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledJfxToolbar(vararg styleClass: String, id: String? = null): JFXToolbar =
        styledJfxToolbar(styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXToolbar] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxToolbar(vararg styleClass: String, id: String? = null):
        JFXToolbar = styledJfxToolbar(styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXToolbar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun styledJfxToolbar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxToolbar).() -> Unit,
): JFXToolbar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxToolbar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXToolbar] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun NodeContainer.styledJfxToolbar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxToolbar).() -> Unit,
): JFXToolbar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxToolbar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
