@file:Suppress("NOTHING_TO_INLINE", "PackageDirectoryMismatch", "UsePropertyAccessSyntax")

package ktfx.controlsfx

import java.util.Optional
import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.scene.image.ImageView
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import org.controlsfx.dialog.CommandLinksDialog

/**
 * Build a command links dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param links actual buttons.
 */
fun commandLinksDialog(
    title: String? = null,
    graphic: Node? = null,
    vararg links: CommandLinksDialog.CommandLinksButtonType
): Optional<ButtonType> = CommandLinksDialog(*links).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
}.showAndWait()

/**
 * Build a command links dialog with Kotlin DSL.
 *
 * @param links actual buttons.
 */
inline fun commandLinksDialog(
    vararg links: CommandLinksDialog.CommandLinksButtonType
): Optional<ButtonType> = commandLinksDialog(null, null, *links)

/**
 * Build a command links dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param links actual buttons.
 */
fun commandLinksDialog(
    title: String? = null,
    graphic: Node? = null,
    links: List<CommandLinksDialog.CommandLinksButtonType>
): Optional<ButtonType> = CommandLinksDialog(links).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
}.showAndWait()

/**
 * Build a command links dialog with Kotlin DSL.
 *
 * @param links actual buttons.
 */
inline fun commandLinksDialog(
    links: List<CommandLinksDialog.CommandLinksButtonType>
): Optional<ButtonType> = commandLinksDialog(null, null, links)
