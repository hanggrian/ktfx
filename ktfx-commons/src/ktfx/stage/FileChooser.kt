@file:Suppress("NOTHING_TO_INLINE")

package ktfx.stage

import javafx.stage.FileChooser
import javafx.stage.FileChooser.ExtensionFilter
import javafx.stage.Window
import java.io.File

/**
 * Choose a file to open.
 *
 * @param title title of the dialog.
 * @param initialDirectory starting point of chooser.
 * @param initialFileName starting name of file to be choosen.
 * @param filters expected file extensions.
 * @return chosen file.
 */
fun Window.chooseFile(
    title: String? = null,
    initialDirectory: File? = null,
    initialFileName: String? = null,
    vararg filters: ExtensionFilter
): File = FileChooser().also {
    if (title != null) it.title = title
    if (initialDirectory != null) it.initialDirectory = initialDirectory
    if (initialFileName != null) it.initialFileName = initialFileName
    if (filters.isNotEmpty()) it.extensionFilters += filters
}.showOpenDialog(this)

/**
 * Choose multiple files to open.
 *
 * @param title title of the dialog.
 * @param initialDirectory starting point of chooser.
 * @param initialFileName starting name of file to be choosen.
 * @param filters expected file extensions.
 * @return chosen files.
 */
fun Window.chooseFiles(
    title: String? = null,
    initialDirectory: File? = null,
    initialFileName: String? = null,
    vararg filters: ExtensionFilter
): List<File> = FileChooser().also {
    if (title != null) it.title = title
    if (initialDirectory != null) it.initialDirectory = initialDirectory
    if (initialFileName != null) it.initialFileName = initialFileName
    if (filters.isNotEmpty()) it.extensionFilters += filters
}.showOpenMultipleDialog(this)

/**
 * Choose a file to save.
 *
 * @param title title of the dialog.
 * @param initialDirectory starting point of chooser.
 * @param initialFileName starting name of file to be choosen.
 * @param filters expected file extensions.
 * @return chosen file.
 */
fun Window.chooseSaveFile(
    title: String? = null,
    initialDirectory: File? = null,
    initialFileName: String? = null,
    vararg filters: ExtensionFilter
): File = FileChooser().also {
    if (title != null) it.title = title
    if (initialDirectory != null) it.initialDirectory = initialDirectory
    if (initialFileName != null) it.initialFileName = initialFileName
    if (filters.isNotEmpty()) it.extensionFilters += filters
}.showSaveDialog(this)