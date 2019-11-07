@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDatePicker
import java.time.LocalDate
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXDatePicker] with initialization block. */
inline fun jfxDatePicker(
    date: LocalDate? = null,
    init: (@LayoutDslMarker JFXDatePicker).() -> Unit
): JFXDatePicker {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXDatePicker(date).apply(init)
}
/** Add a [JFXDatePicker] to this manager. */
fun NodeManager.jfxDatePicker(
    date: LocalDate? = null
): JFXDatePicker = addNode(JFXDatePicker(date))

/** Add a [JFXDatePicker] with initialization block to this manager. */
inline fun NodeManager.jfxDatePicker(
    date: LocalDate? = null,
    init: (@LayoutDslMarker JFXDatePicker).() -> Unit
): JFXDatePicker {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXDatePicker(date), init)
}
