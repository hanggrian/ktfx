@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.dialogs

import javafx.scene.Node
import javafx.scene.control.ChoiceDialog
import javafx.scene.image.ImageView
import java.util.Optional

/**
 * Show a selector with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param items selection choices.
 * @param prefill default choice.
 * @return selected item.
 */
fun <T> selector(
    title: String? = null,
    graphic: Node? = null,
    items: Collection<T>? = null,
    prefill: T? = null
): Optional<T> = ChoiceDialog<T>(prefill, items).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
}.showAndWait()

/**
 * Show a selector.
 *
 * @param items selection choices.
 * @param prefill default choice.
 * @return selected item.
 */
inline fun <T> selector(
    items: Collection<T>? = null,
    prefill: T? = null
): Optional<T> = selector(null, null, items, prefill)

/**
 * Show a selector with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param items selection choices.
 * @param prefill default choice.
 * @return selected item.
 */
fun <T> selector(
    title: String? = null,
    graphic: Node? = null,
    vararg items: T,
    prefill: T? = null
): Optional<T> = ChoiceDialog<T>(prefill, *items).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
}.showAndWait()

/**
 * Show a selector.
 *
 * @param items selection choices.
 * @param prefill default choice.
 * @return selected item.
 */
inline fun <T> selector(
    vararg items: T,
    prefill: T? = null
): Optional<T> = selector(null, null, *items, prefill = prefill)