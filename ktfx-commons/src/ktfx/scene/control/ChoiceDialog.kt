@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.scene.control

import javafx.scene.Node
import javafx.scene.control.ChoiceDialog
import javafx.scene.image.ImageView

/**
 * Build a choice dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param items selection choices.
 * @param prefill default choice.
 * @param init custom initialization block.
 */
fun <T> choiceDialog(
    title: String? = null,
    graphic: Node? = null,
    items: Collection<T>? = null,
    prefill: T? = null,
    init: (ChoiceDialog<T>.() -> Unit)? = null
): ChoiceDialog<T> = ChoiceDialog<T>(prefill, items).also { dialog ->
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
    init?.invoke(dialog)
}

/**
 * Build a choice dialog with Kotlin DSL.
 *
 * @param items selection choices.
 * @param prefill default choice.
 * @param init custom initialization block.
 */
inline fun <T> choiceDialog(
    items: Collection<T>? = null,
    prefill: T? = null,
    noinline init: (ChoiceDialog<T>.() -> Unit)? = null
): ChoiceDialog<T> = choiceDialog(null, null, items, prefill, init)

/**
 * Build a styled choice dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param graphic node to be displayed in header.
 * @param items selection choices.
 * @param prefill default choice.
 * @param init custom initialization block.
 */
fun <T> styledChoiceDialog(
    stylesheet: String,
    title: String? = null,
    graphic: Node? = null,
    items: Collection<T>? = null,
    prefill: T? = null,
    init: (ChoiceDialog<T>.() -> Unit)? = null
): ChoiceDialog<T> = ChoiceDialog<T>(prefill, items).also { dialog ->
    dialog.dialogPane.stylesheets += stylesheet
    if (title != null) dialog.headerTitle = title
    if (graphic != null) (graphic as? ImageView)?.let { dialog.graphicIcon = it } ?: dialog.setGraphic(graphic)
    init?.invoke(dialog)
}

/**
 * Build a styled choice dialog with Kotlin DSL.
 *
 * @param items selection choices.
 * @param prefill default choice.
 * @param init custom initialization block.
 */
inline fun <T> styledChoiceDialog(
    stylesheet: String,
    items: Collection<T>? = null,
    prefill: T? = null,
    noinline init: (ChoiceDialog<T>.() -> Unit)? = null
): ChoiceDialog<T> = styledChoiceDialog(stylesheet, null, null, items, prefill, init)