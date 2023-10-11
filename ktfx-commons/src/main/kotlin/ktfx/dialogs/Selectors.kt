@file:Suppress("NOTHING_TO_INLINE")

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
 * @param dialogAction custom dialog action.
 * @return selected item.
 */
fun <T> selector(
    title: String? = null,
    graphic: Node? = null,
    items: Collection<T>? = null,
    prefill: T? = null,
    dialogAction: (ChoiceDialog<T>.() -> Unit)? = null
): Optional<T> = ChoiceDialog<T>(prefill, items).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
    dialogAction?.invoke(dialog)
}.showAndWait()

/**
 * Show a selector.
 *
 * @param items selection choices.
 * @param prefill default choice.
 * @param dialogAction custom dialog action.
 * @return selected item.
 */
inline fun <T> selector(
    items: Collection<T>? = null,
    prefill: T? = null,
    noinline dialogAction: (ChoiceDialog<T>.() -> Unit)? = null
): Optional<T> = selector(null, null, items, prefill, dialogAction)

/**
 * Show a selector with title and graphic.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param items selection choices.
 * @param prefill default choice.
 * @param dialogAction custom dialog action.
 * @return selected item.
 */
fun <T> selector(
    title: String? = null,
    graphic: Node? = null,
    vararg items: T,
    prefill: T? = null,
    dialogAction: (ChoiceDialog<T>.() -> Unit)? = null
): Optional<T> = ChoiceDialog<T>(prefill, *items).also { dialog ->
    if (title != null) dialog.headerTitle = title
    when {
        graphic is ImageView -> dialog.graphicIcon = graphic
        graphic != null -> dialog.graphic = graphic
    }
    dialogAction?.invoke(dialog)
}.showAndWait()

/**
 * Show a selector.
 *
 * @param items selection choices.
 * @param prefill default choice.
 * @param dialogAction custom dialog action.
 * @return selected item.
 */
inline fun <T> selector(
    vararg items: T,
    prefill: T? = null,
    noinline dialogAction: (ChoiceDialog<T>.() -> Unit)? = null
): Optional<T> = selector(null, null, *items, prefill = prefill, dialogAction = dialogAction)
