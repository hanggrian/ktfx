@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTimePicker
import java.time.LocalTime
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
 * Add a [JFXTimePicker] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxTimePicker(time: LocalTime? = null): JFXTimePicker =
        jfxTimePicker(time = time) { }

/**
 * Create a [JFXTimePicker] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun jfxTimePicker(time: LocalTime? = null, configuration: (@KtfxLayoutDslMarker
        JFXTimePicker).() -> Unit): JFXTimePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTimePicker(time)
    child.configuration()
    return child
}

/**
 * Add a [JFXTimePicker] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxTimePicker(time: LocalTime? = null, configuration: (@KtfxLayoutDslMarker
        JFXTimePicker).() -> Unit): JFXTimePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTimePicker(time)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTimePicker].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledJfxTimePicker(
    time: LocalTime? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXTimePicker = styledJfxTimePicker(time = time, styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXTimePicker] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxTimePicker(
    time: LocalTime? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXTimePicker = styledJfxTimePicker(time = time, styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXTimePicker] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledJfxTimePicker(
    time: LocalTime? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTimePicker).() -> Unit,
): JFXTimePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTimePicker(time)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTimePicker] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledJfxTimePicker(
    time: LocalTime? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTimePicker).() -> Unit,
): JFXTimePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTimePicker(time)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
