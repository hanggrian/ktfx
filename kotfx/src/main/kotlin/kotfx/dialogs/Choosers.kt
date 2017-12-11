@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.stage.DirectoryChooser
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

/** Creates a directory chooser dialog with title and optional initialization block. */
@JvmOverloads
inline fun directoryChooser(
        title: String,
        noinline init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser = DirectoryChooser().apply {
    this.title = title
    init?.invoke(this)
}

/** Creates a directory chooser dialog with optional initialization block. */
@JvmOverloads
inline fun directoryChooser(
        noinline init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser = DirectoryChooser().apply {
    init?.invoke(this)
}