@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.textfield.CustomTextField

/** Create a [CustomTextField] with configurationialization block. */
inline fun customTextField(
    configuration: (@LayoutDslMarker CustomTextField).() -> Unit
): CustomTextField {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return CustomTextField().apply(configuration)
}

/** Add a [CustomTextField] to this manager. */
fun NodeManager.customTextField(): CustomTextField = addChild(CustomTextField())

/** Add a [CustomTextField] with configurationialization block to this manager. */
inline fun NodeManager.customTextField(
    configuration: (@LayoutDslMarker CustomTextField).() -> Unit
): CustomTextField {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(CustomTextField(), configuration)
}
