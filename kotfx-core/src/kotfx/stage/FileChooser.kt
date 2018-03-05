@file:Suppress("NOTHING_TO_INLINE")

package kotfx.stage

import javafx.stage.FileChooser
import java.io.File

inline fun fileChooser(
    description: String,
    vararg extensions: String,
    noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooser(FileChooser.ExtensionFilter(description, *extensions), init = init)

inline fun fileChooser(
    vararg filters: FileChooser.ExtensionFilter,
    noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooser(null, null, null, *filters, init = init)

inline fun fileChooser(
    title: String?,
    vararg filters: FileChooser.ExtensionFilter,
    noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooser(title, null, null, *filters, init = init)

inline fun fileChooser(
    initialDirectory: File?,
    initialFileName: String?,
    vararg filters: FileChooser.ExtensionFilter,
    noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooser(null, initialDirectory, initialFileName, *filters, init = init)

fun fileChooser(
    title: String?,
    initialDirectory: File?,
    initialFileName: String?,
    vararg filters: FileChooser.ExtensionFilter,
    init: (FileChooser.() -> Unit)? = null
): FileChooser = FileChooser().apply {
    if (title != null) setTitle(title)
    if (initialDirectory != null) setInitialDirectory(initialDirectory)
    if (initialFileName != null) setInitialFileName(initialFileName)
    if (filters.isNotEmpty()) extensionFilters.addAll(*filters)
    init?.invoke(this)
}