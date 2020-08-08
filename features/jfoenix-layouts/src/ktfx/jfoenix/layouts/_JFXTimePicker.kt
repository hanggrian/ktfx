@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTimePicker
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import java.time.LocalTime
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXTimePicker] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxTimePicker(time: LocalTime? = null): JFXTimePicker = jfxTimePicker(time = time) {
}

/**
 * Create a [JFXTimePicker] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxTimePicker(
    time: LocalTime? = null,
    configuration: (
        @LayoutDslMarker    
        JFXTimePicker
    ).() -> Unit
): JFXTimePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXTimePicker(time), configuration = configuration)
}

/**
 * Add a [JFXTimePicker] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxTimePicker(
    time: LocalTime? = null,
    configuration: (
        @LayoutDslMarker    
        JFXTimePicker
    ).() -> Unit
): JFXTimePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXTimePicker(time), configuration = configuration))
}

/**
 * Create a styled [JFXTimePicker].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledJFXTimePicker(
    time: LocalTime? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTimePicker = styledJFXTimePicker(time = time, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTimePicker] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledJFXTimePicker(
    time: LocalTime? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTimePicker = styledJFXTimePicker(time = time, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTimePicker] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledJFXTimePicker(
    time: LocalTime? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXTimePicker).() -> Unit
): JFXTimePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        JFXTimePicker(time), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [JFXTimePicker] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXTimePicker(
    time: LocalTime? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXTimePicker).() -> Unit
): JFXTimePicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            JFXTimePicker(time), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}
