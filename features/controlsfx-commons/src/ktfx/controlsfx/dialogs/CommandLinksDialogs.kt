@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.dialogs

import java.util.Optional
import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.scene.image.ImageView
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import org.controlsfx.dialog.CommandLinksDialog

/**
 * Build a command links dialog with Kotlin DSL.
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param links actual buttons.
 * @param dialogAction custom dialog action.
 * @return selected dialog button.
 */
fun commandLinksDialog(
    title: String? = null,
    graphic: Node? = null,
    vararg links: CommandLinksDialog.CommandLinksButtonType,
    dialogAction: (CommandLinksDialog.() -> Unit)? = null
): Optional<ButtonType> = CommandLinksDialog(*links).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
    dialogAction?.invoke(dialog)
}.showAndWait()

/**
 * Build a command links dialog with Kotlin DSL.
 * @param links actual buttons.
 * @param dialogAction custom dialog action.
 * @return selected dialog button.
 */
inline fun commandLinksDialog(
    vararg links: CommandLinksDialog.CommandLinksButtonType,
    noinline dialogAction: (CommandLinksDialog.() -> Unit)? = null
): Optional<ButtonType> = commandLinksDialog(null, null, *links, dialogAction = dialogAction)

/**
 * Build a command links dialog with Kotlin DSL.
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param links actual buttons.
 * @param dialogAction custom dialog action.
 * @return selected dialog button.
 */
fun commandLinksDialog(
    title: String? = null,
    graphic: Node? = null,
    links: List<CommandLinksDialog.CommandLinksButtonType>,
    dialogAction: (CommandLinksDialog.() -> Unit)? = null
): Optional<ButtonType> = CommandLinksDialog(links).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
    dialogAction?.invoke(dialog)
}.showAndWait()

/**
 * Build a command links dialog with Kotlin DSL.
 * @param links actual buttons.
 * @param dialogAction custom dialog action.
 * @return selected dialog button.
 */
inline fun commandLinksDialog(
    links: List<CommandLinksDialog.CommandLinksButtonType>,
    noinline dialogAction: (CommandLinksDialog.() -> Unit)? = null
): Optional<ButtonType> = commandLinksDialog(null, null, links, dialogAction = dialogAction)
