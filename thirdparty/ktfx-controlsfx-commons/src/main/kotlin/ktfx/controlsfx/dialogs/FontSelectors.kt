@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.dialogs

import javafx.scene.Node
import javafx.scene.image.ImageView
import javafx.scene.text.Font
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import org.controlsfx.dialog.FontSelectorDialog
import java.util.Optional

/**
 * Build a font selector dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param defaultFont initially selected font.
 * @param dialogAction custom dialog action.
 * @return selected font.
 */
public fun fontSelector(
    title: String? = null,
    graphic: Node? = null,
    defaultFont: Font? = null,
    dialogAction: (FontSelectorDialog.() -> Unit)? = null,
): Optional<Font> =
    FontSelectorDialog(defaultFont)
        .also { dialog ->
            if (title != null) dialog.headerTitle = title
            when {
                graphic is ImageView -> dialog.graphicIcon = graphic
                graphic != null -> dialog.graphic = graphic
            }
            dialogAction?.invoke(dialog)
        }.showAndWait()

/**
 * Build a font selector dialog with Kotlin DSL.
 *
 * @param defaultFont initially selected font.
 * @param dialogAction custom dialog action.
 * @return selected font.
 */
public inline fun fontSelector(
    defaultFont: Font? = null,
    noinline dialogAction: (FontSelectorDialog.() -> Unit)? = null,
): Optional<Font> = fontSelector(null, null, defaultFont, dialogAction)
