@file:Suppress("NOTHING_TO_INLINE")

package kfx.stage

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
): FileChooser = FileChooser().also {
    if (title != null) it.title = title
    if (initialDirectory != null) it.initialDirectory = initialDirectory
    if (initialFileName != null) it.initialFileName = initialFileName
    if (filters.isNotEmpty()) it.extensionFilters += filters
    init?.invoke(it)
}