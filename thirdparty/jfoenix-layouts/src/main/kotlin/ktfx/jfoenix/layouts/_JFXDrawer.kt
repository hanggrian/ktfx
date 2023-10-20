@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
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

/**
 * Add a [JFXDrawer] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxDrawer(): JFXDrawer = jfxDrawer() { }

/**
 * Create a [JFXDrawer] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxDrawer(configuration: (@KtfxLayoutDslMarker KtfxJfxDrawer).() -> Unit):
        JFXDrawer {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxDrawer()
    child.configuration()
    return child
}

/**
 * Add a [JFXDrawer] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.jfxDrawer(configuration: (@KtfxLayoutDslMarker
        KtfxJfxDrawer).() -> Unit): JFXDrawer {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxDrawer()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXDrawer].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledJFXDrawer(vararg styleClass: String, id: String? = null): JFXDrawer =
        styledJFXDrawer(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXDrawer] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledJFXDrawer(vararg styleClass: String, id: String? = null): JFXDrawer =
        styledJFXDrawer(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXDrawer] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJFXDrawer(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxDrawer).() -> Unit,
): JFXDrawer {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxDrawer()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXDrawer] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJFXDrawer(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxDrawer).() -> Unit,
): JFXDrawer {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxDrawer()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
