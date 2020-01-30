@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.dialogs

import java.util.Optional
import javafx.scene.Node
import javafx.scene.image.ImageView
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import ktfx.util.toFxPair
import ktfx.util.toKotlinPair
import org.controlsfx.dialog.LoginDialog

/**
 * Build a login dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param initialUserInfo may be null for empty fields.
 * @param authenticator login callback.
 * @param builderAction custom dialog builder action.
 * @return login user and password credential.
 */
fun loginDialog(
    title: String? = null,
    graphic: Node? = null,
    initialUserInfo: Pair<String, String>? = null,
    authenticator: (Pair<String, String>) -> Unit,
    builderAction: (LoginDialog.() -> Unit)? = null
): Optional<javafx.util.Pair<String, String>> = LoginDialog(
    initialUserInfo?.toFxPair()
) { authenticator(it.toKotlinPair()); null }.also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
    builderAction?.invoke(dialog)
}.showAndWait()

/**
 * Build a login dialog with Kotlin DSL.
 *
 * @param initialUserInfo may be null for empty fields.
 * @param authenticator login callback.
 * @param builderAction custom dialog builder action.
 * @return login user and password credential.
 */
inline fun loginDialog(
    initialUserInfo: Pair<String, String>? = null,
    noinline authenticator: (Pair<String, String>) -> Unit,
    noinline builderAction: (LoginDialog.() -> Unit)? = null
): Optional<javafx.util.Pair<String, String>> = loginDialog(null, null, initialUserInfo, authenticator, builderAction)
