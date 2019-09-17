@file:Suppress("NOTHING_TO_INLINE", "PackageDirectoryMismatch", "UsePropertyAccessSyntax")

package ktfx.controlsfx

import java.util.Optional
import javafx.scene.Node
import javafx.scene.image.ImageView
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import ktfx.internal.KtfxJavaInternals
import ktfx.toFxPair
import ktfx.toKotlinPair
import org.controlsfx.dialog.LoginDialog

/**
 * Build a login dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param initialUserInfo may be null for empty fields.
 * @param authenticator login callback.
 */
fun loginDialog(
    title: String? = null,
    graphic: Node? = null,
    initialUserInfo: Pair<String, String>? = null,
    authenticator: (Pair<String, String>) -> Unit
): Optional<javafx.util.Pair<String, String>> = LoginDialog(
    initialUserInfo?.toFxPair(),
    KtfxJavaInternals.noReturn { authenticator(it.toKotlinPair()) }
).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
}.showAndWait()

/**
 * Build a login dialog with Kotlin DSL.
 *
 * @param initialUserInfo may be null for empty fields.
 * @param authenticator login callback.
 */
inline fun loginDialog(
    initialUserInfo: Pair<String, String>? = null,
    noinline authenticator: (Pair<String, String>) -> Unit
): Optional<javafx.util.Pair<String, String>> = loginDialog(null, null, initialUserInfo, authenticator)