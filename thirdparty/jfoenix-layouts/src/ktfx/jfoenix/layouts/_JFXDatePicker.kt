@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDatePicker
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import java.time.LocalDate
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXDatePicker] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxDatePicker(date: LocalDate? = null): JFXDatePicker = jfxDatePicker(date = date) {
}

/**
 * Create a [JFXDatePicker] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxDatePicker(
    date: LocalDate? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        JFXDatePicker
    ).() -> Unit
): JFXDatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDatePicker(date)
    child.configuration()
    return child
}

/**
 * Add a [JFXDatePicker] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxDatePicker(
    date: LocalDate? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        JFXDatePicker
    ).() -> Unit
): JFXDatePicker {
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
fun styledJFXDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null
): JFXDatePicker = styledJFXDatePicker(date = date, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXDatePicker] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledJFXDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null
): JFXDatePicker = styledJFXDatePicker(date = date, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXDatePicker] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledJFXDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXDatePicker).() -> Unit
): JFXDatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDatePicker(date)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXDatePicker] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXDatePicker(
    date: LocalDate? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXDatePicker).() -> Unit
): JFXDatePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDatePicker(date)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
