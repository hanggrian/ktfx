@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXBadge
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXBadge] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.jfxBadge(): JFXBadge = jfxBadge() { }

/**
 * Create a [JFXBadge] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxBadge(configuration: (@KtfxLayoutDslMarker KtfxJFXBadge).() -> Unit):
    JFXBadge {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXBadge()
    child.configuration()
    return child
}

/**
 * Add a [JFXBadge] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.jfxBadge(
    configuration: (@KtfxLayoutDslMarker KtfxJFXBadge).() ->
    Unit
): JFXBadge {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXBadge()
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
public fun styledJFXBadge(vararg styleClass: String, id: String? = null): JFXBadge =
    styledJFXBadge(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXBadge] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledJFXBadge(vararg styleClass: String, id: String? = null): JFXBadge =
    styledJFXBadge(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXBadge] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJFXBadge(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJFXBadge).() -> Unit
): JFXBadge {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXBadge()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXBadge] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledJFXBadge(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJFXBadge).() -> Unit
): JFXBadge {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXBadge()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
