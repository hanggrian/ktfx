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
import org.controlsfx.control.textfield.CustomTextField

/** Create a [CustomTextField] with initialization block. */
inline fun customTextField(
    init: (@LayoutsDslMarker CustomTextField).() -> Unit
): CustomTextField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return CustomTextField().apply(init)
}

/** Add a [CustomTextField] to this manager. */
fun NodeManager.customTextField(): CustomTextField = addChild(CustomTextField())

/** Add a [CustomTextField] with initialization block to this manager. */
inline fun NodeManager.customTextField(
    init: (@LayoutsDslMarker CustomTextField).() -> Unit
): CustomTextField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(CustomTextField(), init)
}
