@file:Suppress("NOTHING_TO_INLINE")

package kotfx.scene.dialogs

import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser
import javafx.stage.FileChooser.ExtensionFilter
import java.io.File

inline fun fileChooser(
    description: String,
    vararg extensions: String,
    noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooser(ExtensionFilter(description, *extensions), init = init)

inline fun fileChooser(
    vararg filters: ExtensionFilter,
    noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooser(null, null, null, *filters, init = init)

inline fun fileChooser(
    title: String?,
    vararg filters: ExtensionFilter,
    noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooser(title, null, null, *filters, init = init)

inline fun fileChooser(
    initialDirectory: File?,
    initialFileName: String?,
    vararg filters: ExtensionFilter,
    noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooser(null, initialDirectory, initialFileName, *filters, init = init)

fun fileChooser(
    title: String?,
    initialDirectory: File?,
    initialFileName: String?,
    vararg filters: ExtensionFilter,
    init: (FileChooser.() -> Unit)? = null
): FileChooser = FileChooser().apply {
    if (title != null) setTitle(title)
    if (initialDirectory != null) setInitialDirectory(initialDirectory)
    if (initialFileName != null) setInitialFileName(initialFileName)
    if (filters.isNotEmpty()) extensionFilters.addAll(*filters)
    init?.invoke(this)
}

inline fun directoryChooser(
    initialDirectory: File? = null,
    noinline init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser = directoryChooser(null, initialDirectory, init)

fun directoryChooser(
    title: String?,
    initialDirectory: File? = null,
    init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser = DirectoryChooser().apply {
    if (title != null) setTitle(title)
    if (initialDirectory != null) setInitialDirectory(initialDirectory)
    init?.invoke(this)
}