@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.thirdparty.controlsfx.dialogs

import java.util.Optional
import javafx.scene.Node
import javafx.scene.image.ImageView
import javafx.scene.text.Font
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import org.controlsfx.dialog.FontSelectorDialog

/**
 * Build a font selector dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param defaultFont initially selected font.
 */
fun fontSelectorDialog(
    title: String? = null,
    graphic: Node? = null,
    defaultFont: Font? = null
): Optional<Font> = FontSelectorDialog(defaultFont).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
}.showAndWait()

/**
 * Build a font selector dialog with Kotlin DSL.
 *
 * @param defaultFont initially selected font.
 */
inline fun fontSelectorDialog(
    defaultFont: Font? = null
): Optional<Font> = fontSelectorDialog(null, null, defaultFont)
