@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.PasswordField
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [PasswordField] with configurationialization block. */
inline fun passwordField(
    configuration: (@LayoutDslMarker PasswordField).() -> Unit
): PasswordField {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return PasswordField().apply(configuration)
}

/** Add a [PasswordField] to this manager. */
fun NodeManager.passwordField(): PasswordField = addChild(PasswordField())

/** Add a [PasswordField] with configurationialization block to this manager. */
inline fun NodeManager.passwordField(
    configuration: (@LayoutDslMarker PasswordField).() -> Unit
): PasswordField {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(PasswordField(), configuration)
}
