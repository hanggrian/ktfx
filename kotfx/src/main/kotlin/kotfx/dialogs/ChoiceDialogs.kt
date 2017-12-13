@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.ChoiceDialog
import javafx.stage.Window
import kotfx.internal.DialogDsl

class _ChoiceDialog<T>(items: Collection<T>?, defaultItem: T?) : ChoiceDialog<T>(defaultItem, items), Dialoggable<ChoiceDialog<T>, T> {
    override val dialog: ChoiceDialog<T> get() = this
    fun select(item: T) = setSelectedItem(item)
}

@JvmOverloads
inline fun <T> choiceDialog(
        title: String,
        items: Collection<T>? = null,
        prefill: T? = null,
        noinline init: ((@DialogDsl _ChoiceDialog<T>).() -> Unit)? = null
): ChoiceDialog<T> = _ChoiceDialog(items, prefill).apply {
    title(title)
    if (init != null) init()
}

@JvmOverloads
inline fun <T> Window.choiceDialog(
        title: String,
        items: Collection<T>? = null,
        prefill: T? = null,
        noinline init: ((@DialogDsl _ChoiceDialog<T>).() -> Unit)? = null
): ChoiceDialog<T> = _ChoiceDialog(items, prefill).apply {
    initOwner(this@choiceDialog)
    title(title)
    if (init != null) init()
}