@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.dialogs

import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser

/** Creates a file chooser dialog with title, extension filters and optional initialization block. */
@JvmOverloads
inline fun fileChooser(
        title: String,
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: (FileChooser.() -> Unit)? = null
): FileChooser {
    val chooser = FileChooser()
    chooser.title = title
    chooser.extensionFilters.addAll(*filters)
    init?.let { chooser.it() }
    return chooser
}

/** Creates a file chooser dialog with extension filters and optional initialization block. */
@JvmOverloads
inline fun fileChooser(
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: (FileChooser.() -> Unit)? = null
): FileChooser {
    val chooser = FileChooser()
    chooser.extensionFilters.addAll(*filters)
    init?.let { chooser.it() }
    return chooser
}

/** Creates a directory chooser dialog with title and optional initialization block. */
@JvmOverloads
inline fun directoryChooser(
        title: String,
        noinline init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser {
    val chooser = DirectoryChooser()
    chooser.title = title
    init?.let { chooser.it() }
    return chooser
}

/** Creates a directory chooser dialog with optional initialization block. */
@JvmOverloads
inline fun directoryChooser(
        noinline init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser {
    val chooser = DirectoryChooser()
    init?.let { chooser.it() }
    return chooser
}