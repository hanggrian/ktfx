@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.textfield.CustomPasswordField

/** Create a [CustomPasswordField] with initialization block. */
inline fun customPasswordField(
    init: (@LayoutsDslMarker CustomPasswordField).() -> Unit
): CustomPasswordField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return CustomPasswordField().apply(init)
}

/** Add a [CustomPasswordField] to this manager. */
fun NodeManager.customPasswordField(): CustomPasswordField = addChild(CustomPasswordField())

/** Add a [CustomPasswordField] with initialization block to this manager. */
inline fun NodeManager.customPasswordField(
    init: (@LayoutsDslMarker CustomPasswordField).() -> Unit
): CustomPasswordField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(CustomPasswordField(), init)
}
