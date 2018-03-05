@file:Suppress("NOTHING_TO_INLINE")

package kotlinfx.stage

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
): DirectoryChooser = DirectoryChooser().apply {
    if (title != null) setTitle(title)
    if (initialDirectory != null) setInitialDirectory(initialDirectory)
    init?.invoke(this)
}