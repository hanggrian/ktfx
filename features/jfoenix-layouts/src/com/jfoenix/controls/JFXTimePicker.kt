@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTimePicker
import java.time.LocalTime
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXTimePicker] with initialization block. */
inline fun jfxTimePicker(
    value: LocalTime? = null,
    configuration: (@LayoutsDslMarker JFXTimePicker).() -> Unit
): JFXTimePicker {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXTimePicker(value).apply(configuration)
}

/** Add a [JFXTimePicker] to this manager. */
fun NodeManager.jfxTimePicker(
    value: LocalTime? = null
): JFXTimePicker = addChild(JFXTimePicker(value))

/** Add a [JFXTimePicker] with initialization block to this manager. */
inline fun NodeManager.jfxTimePicker(
    value: LocalTime? = null,
    configuration: (@LayoutsDslMarker JFXTimePicker).() -> Unit
): JFXTimePicker {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXTimePicker(value), configuration)
}
