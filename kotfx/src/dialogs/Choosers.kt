@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser
import java.io.File

@JvmOverloads
inline fun fileChooser(
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = FileChooser().apply {
    extensionFilters.addAll(*filters)
    init?.invoke(this)
}

@JvmOverloads
inline fun fileChooser(
        description: String,
        vararg extensions: String,
        noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooser(FileChooser.ExtensionFilter(description, *extensions), init = init)

@JvmOverloads
inline fun directoryChooser(
        initialDirectory: File? = null,
        noinline init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser = DirectoryChooser().apply {
    initialDirectory?.let { setInitialDirectory(it) }
    init?.invoke(this)
}