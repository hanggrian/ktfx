@file:Suppress("NOTHING_TO_INLINE")

package kfx.stage

import javafx.stage.DirectoryChooser
import java.io.File

inline fun directoryChooser(
    initialDirectory: File? = null,
    noinline init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser = directoryChooser(null, initialDirectory, init)

fun directoryChooser(
    title: String?,
    initialDirectory: File? = null,
    init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser = DirectoryChooser().also {
    if (title != null) it.title = title
    if (initialDirectory != null) it.initialDirectory = initialDirectory
    init?.invoke(it)
}