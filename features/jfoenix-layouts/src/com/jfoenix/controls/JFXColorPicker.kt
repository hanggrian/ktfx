@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXColorPicker
import javafx.scene.paint.Color
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXColorPicker] with initialization block. */
inline fun jfxColorPicker(
    value: Color? = null,
    configuration: (@LayoutsDslMarker JFXColorPicker).() -> Unit
): JFXColorPicker {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXColorPicker(value).apply(configuration)
}

/** Add a [JFXColorPicker] to this manager. */
fun NodeManager.jfxColorPicker(
    value: Color? = null
): JFXColorPicker = addChild(JFXColorPicker(value))

/** Add a [JFXColorPicker] with initialization block to this manager. */
inline fun NodeManager.jfxColorPicker(
    value: Color? = null,
    configuration: (@LayoutsDslMarker JFXColorPicker).() -> Unit
): JFXColorPicker {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXColorPicker(value), configuration)
}
