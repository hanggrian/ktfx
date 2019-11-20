@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXColorPicker
import javafx.scene.paint.Color
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.KtfxLayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXColorPicker] with initialization block. */
inline fun jfxColorPicker(
    color: Color? = null,
    init: (@KtfxLayoutsDslMarker JFXColorPicker).() -> Unit
): JFXColorPicker {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXColorPicker(color).apply(init)
}

/** Add a [JFXColorPicker] to this manager. */
fun NodeManager.jfxColorPicker(
    color: Color? = null
): JFXColorPicker = addNode(JFXColorPicker(color))

/** Add a [JFXColorPicker] with initialization block to this manager. */
inline fun NodeManager.jfxColorPicker(
    color: Color? = null,
    init: (@KtfxLayoutsDslMarker JFXColorPicker).() -> Unit
): JFXColorPicker {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXColorPicker(color), init)
}
