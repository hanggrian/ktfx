@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.dialogs

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
 * @param builderAction custom dialog builder action.
 * @return selected font.
 */
fun fontSelector(
    title: String? = null,
    graphic: Node? = null,
    defaultFont: Font? = null,
    builderAction: (FontSelectorDialog.() -> Unit)? = null
): Optional<Font> = FontSelectorDialog(defaultFont).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
    builderAction?.invoke(dialog)
}.showAndWait()

/**
 * Build a font selector dialog with Kotlin DSL.
 *
 * @param defaultFont initially selected font.
 * @param builderAction custom dialog builder action.
 * @return selected font.
 */
inline fun fontSelector(
    defaultFont: Font? = null,
    noinline builderAction: (FontSelectorDialog.() -> Unit)? = null
): Optional<Font> = fontSelector(null, null, defaultFont, builderAction)
