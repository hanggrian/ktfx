@file:Suppress("NOTHING_TO_INLINE")

package ktfx.dialogs

import javafx.stage.DirectoryChooser
import javafx.stage.Window
import java.io.File

/**
 * Choose a directory.
 *
 * @param title title of the dialog.
 * @param initialDirectory starting point of chooser.
 * @return chosen directory.
 */
fun Window.chooseDirectory(
    title: String? = null,
    initialDirectory: File? = null
): File? = DirectoryChooser().also {
    if (title != null) it.title = title
    if (initialDirectory != null) it.initialDirectory = initialDirectory
}.showDialog(this)