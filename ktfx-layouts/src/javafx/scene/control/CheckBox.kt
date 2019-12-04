@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.CheckBox
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [CheckBox] with initialization block. */
inline fun checkBox(
    text: String? = null,
    init: (@LayoutsDslMarker CheckBox).() -> Unit
): CheckBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return CheckBox(text).apply(init)
}

/** Add a [CheckBox] to this manager. */
fun NodeManager.checkBox(
    text: String? = null
): CheckBox = addChild(CheckBox(text))

/** Add a [CheckBox] with initialization block to this manager. */
inline fun NodeManager.checkBox(
    text: String? = null,
    init: (@LayoutsDslMarker CheckBox).() -> Unit
): CheckBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(CheckBox(text), init)
}
