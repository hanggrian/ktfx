@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.PasswordField
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [PasswordField] with initialization block. */
inline fun passwordField(
    init: (@LayoutsDslMarker PasswordField).() -> Unit
): PasswordField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return PasswordField().apply(init)
}

/** Add a [PasswordField] to this manager. */
fun NodeManager.passwordField(): PasswordField =
    addNode(PasswordField())

/** Add a [PasswordField] with initialization block to this manager. */
inline fun NodeManager.passwordField(
    init: (@LayoutsDslMarker PasswordField).() -> Unit
): PasswordField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(PasswordField(), init)
}
