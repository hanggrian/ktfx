@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDatePicker
import java.time.LocalDate
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
 * Add a [JFXDatePicker] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxDatePicker(date: LocalDate? = null): JFXDatePicker =
        jfxDatePicker(date = date) { }

/**
 * Create a [JFXDatePicker] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun jfxDatePicker(date: LocalDate? = null, configuration: (@KtfxLayoutDslMarker
        JFXDatePicker).() -> Unit): JFXDatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDatePicker(date)
    child.configuration()
    return child
}

/**
 * Add a [JFXDatePicker] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxDatePicker(date: LocalDate? = null, configuration: (@KtfxLayoutDslMarker
        JFXDatePicker).() -> Unit): JFXDatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDatePicker(date)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXDatePicker].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledJfxDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXDatePicker = styledJfxDatePicker(date = date, styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXDatePicker] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXDatePicker = styledJfxDatePicker(date = date, styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXDatePicker] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledJfxDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXDatePicker).() -> Unit,
): JFXDatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDatePicker(date)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXDatePicker] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledJfxDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXDatePicker).() -> Unit,
): JFXDatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDatePicker(date)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
