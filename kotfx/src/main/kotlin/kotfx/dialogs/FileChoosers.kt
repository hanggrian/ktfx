@file:JvmMultifileClass
@file:JvmName("ChoosersKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.stage.FileChooser

/** Creates a file chooser dialog with title, extension filters and optional initialization block. */
@JvmOverloads
inline fun fileChooser(
        title: String,
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = FileChooser().apply {
    this.title = title
    extensionFilters.addAll(*filters)
    init?.invoke(this)
}

/** Creates a file chooser dialog with extension filters and optional initialization block. */
@JvmOverloads
inline fun fileChooser(
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = FileChooser().apply {
    extensionFilters.addAll(*filters)
    init?.invoke(this)
}