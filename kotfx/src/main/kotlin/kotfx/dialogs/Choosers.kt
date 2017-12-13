@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser
import javafx.stage.Window

/** Creates a file chooser dialog with title, extension filters and optional initialization block. */
@JvmOverloads
inline fun fileChooserOf(
        title: String,
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = FileChooser().apply {
    this.title = title
    extensionFilters.addAll(*filters)
    init?.invoke(this)
}

@JvmOverloads
inline fun Window.fileChooser(
        title: String,
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooserOf(title, *filters, init = init).apply { showOpenDialog(this@fileChooser) }

@JvmOverloads
inline fun Window.multipleFileChooser(
        title: String,
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooserOf(title, *filters, init = init).apply { showOpenMultipleDialog(this@multipleFileChooser) }

@JvmOverloads
inline fun Window.saveFileChooser(
        title: String,
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooserOf(title, *filters, init = init).apply { showSaveDialog(this@saveFileChooser) }

/** Creates a directory chooser dialog with title and optional initialization block. */
@JvmOverloads
inline fun directoryChooserOf(
        title: String,
        noinline init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser = DirectoryChooser().apply {
    this.title = title
    init?.invoke(this)
}

@JvmOverloads
inline fun Window.directoryChooser(
        title: String,
        noinline init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser = directoryChooserOf(title, init).apply { showDialog(this@directoryChooser) }