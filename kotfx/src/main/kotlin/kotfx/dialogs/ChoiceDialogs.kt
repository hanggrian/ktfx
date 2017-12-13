@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.ChoiceDialog
import kotfx.internal.DialogDsl

class _ChoiceDialog<T>(items: Collection<T>?, defaultItem: T?) : ChoiceDialog<T>(defaultItem, items), Dialoggable<ChoiceDialog<T>> {
    override val dialog: ChoiceDialog<T> get() = this

    fun select(value: T) = setSelectedItem(value)
}

@JvmOverloads
inline fun <T> choiceDialogOf(
        title: String,
        items: Collection<T>? = null,
        prefill: T? = null,
        noinline init: ((@DialogDsl _ChoiceDialog<T>).() -> Unit)? = null
): ChoiceDialog<T> = _ChoiceDialog(items, prefill).apply {
    title(title)
    if (init != null) init()
}

@JvmOverloads
inline fun <T> choiceDialog(
        title: String,
        items: Collection<T>? = null,
        prefill: T? = null,
        noinline init: ((@DialogDsl _ChoiceDialog<T>).() -> Unit)? = null
): ChoiceDialog<T> = choiceDialogOf(title, items, prefill, init).apply { show() }

@JvmOverloads
inline fun <T> choiceDialogWait(
        title: String,
        items: Collection<T>? = null,
        prefill: T? = null,
        noinline init: ((@DialogDsl _ChoiceDialog<T>).() -> Unit)? = null
): ChoiceDialog<T> = choiceDialogOf(title, items, prefill, init).apply { showAndWait() }