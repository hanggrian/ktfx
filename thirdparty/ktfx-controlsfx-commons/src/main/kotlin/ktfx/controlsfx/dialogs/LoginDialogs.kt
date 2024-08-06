@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.dialogs

import javafx.scene.Node
import javafx.scene.image.ImageView
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import ktfx.toFxPair
import ktfx.toKotlinPair
import org.controlsfx.dialog.LoginDialog
import java.util.Optional

/**
 * Build a login dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param initialUserInfo may be null for empty fields.
 * @param authenticator login callback.
 * @param dialogAction custom dialog action.
 * @return login user and password credential.
 */
fun loginDialog(
    title: String? = null,
    graphic: Node? = null,
    initialUserInfo: Pair<String, String>? = null,
    authenticator: (Pair<String, String>) -> Unit,
    dialogAction: (LoginDialog.() -> Unit)? = null,
): Optional<javafx.util.Pair<String, String>> =
    LoginDialog(
        initialUserInfo?.toFxPair(),
    ) {
        authenticator(it.toKotlinPair())
        null
    }.also { dialog ->
        if (title != null) dialog.headerTitle = title
        when {
            graphic is ImageView -> dialog.graphicIcon = graphic
            graphic != null -> dialog.graphic = graphic
        }
        dialogAction?.invoke(dialog)
    }.showAndWait()

/**
 * Build a login dialog with Kotlin DSL.
 *
 * @param initialUserInfo may be null for empty fields.
 * @param authenticator login callback.
 * @param dialogAction custom dialog action.
 * @return login user and password credential.
 */
inline fun loginDialog(
    initialUserInfo: Pair<String, String>? = null,
    noinline authenticator: (Pair<String, String>) -> Unit,
    noinline dialogAction: (LoginDialog.() -> Unit)? = null,
): Optional<javafx.util.Pair<String, String>> =
    loginDialog(null, null, initialUserInfo, authenticator, dialogAction)
