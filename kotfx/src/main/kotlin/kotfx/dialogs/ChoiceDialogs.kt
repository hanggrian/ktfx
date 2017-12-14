@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.control.ChoiceDialog
import kotfx.internal.DialogDsl
import java.util.*

class _ChoiceDialog<T>(items: Collection<T>?, defaultItem: T?) : ChoiceDialog<T>(defaultItem, items), DialogBuilder<ChoiceDialog<T>> {
    override val dialog: ChoiceDialog<T> get() = this

    fun select(value: T) = setSelectedItem(value)
}

@JvmOverloads
inline fun <T> choiceDialog(
        title: String? = null,
        items: Collection<T>? = null,
        prefill: T? = null,
        noinline init: ((@DialogDsl _ChoiceDialog<T>).() -> Unit)? = null
): ChoiceDialog<T> = _ChoiceDialog(items, prefill).apply {
    if (title != null) title(title)
    init?.invoke(this)
    show()
}

@JvmOverloads
inline fun <T> choiceDialogWait(
        title: String? = null,
        items: Collection<T>? = null,
        prefill: T? = null,
        noinline init: ((@DialogDsl _ChoiceDialog<T>).() -> Unit)? = null
): Optional<T> = _ChoiceDialog(items, prefill).apply {
    if (title != null) title(title)
    init?.invoke(this)
}.showAndWait()