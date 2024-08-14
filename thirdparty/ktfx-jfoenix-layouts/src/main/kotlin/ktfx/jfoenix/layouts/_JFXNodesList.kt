@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXNodesList
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
 * Add a [JFXNodesList] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxNodesList(): JFXNodesList = jfxNodesList() { }

/**
 * Create a [JFXNodesList] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun jfxNodesList(configuration: (@KtfxLayoutDslMarker KtfxJfxNodesList).() -> Unit):
        JFXNodesList {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxNodesList()
    child.configuration()
    return child
}

/**
 * Add a [JFXNodesList] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun NodeContainer.jfxNodesList(configuration: (@KtfxLayoutDslMarker
        KtfxJfxNodesList).() -> Unit): JFXNodesList {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxNodesList()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXNodesList].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledJfxNodesList(vararg styleClass: String, id: String? = null): JFXNodesList =
        styledJfxNodesList(styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXNodesList] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxNodesList(vararg styleClass: String, id: String? = null):
        JFXNodesList = styledJfxNodesList(styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXNodesList] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun styledJfxNodesList(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxNodesList).() -> Unit,
): JFXNodesList {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxNodesList()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXNodesList] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun NodeContainer.styledJfxNodesList(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJfxNodesList).() -> Unit,
): JFXNodesList {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJfxNodesList()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
