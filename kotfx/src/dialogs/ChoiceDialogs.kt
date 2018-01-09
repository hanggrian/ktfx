@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.ChoiceDialog

@JvmOverloads
inline fun <T> choiceDialog(
        items: Collection<T>? = null,
        prefill: T? = null,
        noinline init: (ChoiceDialog<T>.() -> Unit)? = null
): ChoiceDialog<T> = ChoiceDialog<T>(prefill, items).apply { init?.invoke(this) }