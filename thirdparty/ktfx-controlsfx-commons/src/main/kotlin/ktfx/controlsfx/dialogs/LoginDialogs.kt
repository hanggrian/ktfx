@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.dialogs

import ktfx.toFxPair
import ktfx.toKotlinPair
import org.controlsfx.dialog.LoginDialog
import java.util.Optional
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Build a login dialog with Kotlin DSL.
 *
 * @param initialUserInfo may be null for empty fields.
 * @param authenticator login callback.
 * @param configuration custom dialog action.
 * @return login user and password credential.
 */
public inline fun loginDialog(
    initialUserInfo: Pair<String, String>? = null,
    noinline authenticator: (Pair<String, String>) -> Unit,
    configuration: LoginDialog.() -> Unit,
): Optional<javafx.util.Pair<String, String>> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return LoginDialog(initialUserInfo?.toFxPair()) {
        authenticator(it.toKotlinPair())
        null
    }.apply(configuration)
        .showAndWait()
}
