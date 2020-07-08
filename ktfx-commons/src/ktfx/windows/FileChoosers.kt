@file:Suppress("NOTHING_TO_INLINE")

package ktfx.windows

import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser
import javafx.stage.FileChooser.ExtensionFilter
import javafx.stage.Window
import java.io.File

/**
 * Choose a directory.
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

/**
 * Choose a file to open.
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
): File? = FileChooser().also {
    if (title != null) it.title = title
    if (initialDirectory != null) it.initialDirectory = initialDirectory
    if (initialFileName != null) it.initialFileName = initialFileName
    if (filters.isNotEmpty()) it.extensionFilters += filters
}.showOpenDialog(this)

/**
 * Choose a file to open.
 * @param title title of the dialog.
 * @param initialDirectory starting point of chooser.
 * @param initialFileName starting name of file to be choosen.
 * @param filters expected file extensions.
 * @return chosen file.
 */
inline fun Window.chooseFile(
    title: String? = null,
    initialDirectory: File? = null,
    initialFileName: String? = null,
    vararg filters: Pair<String, String>
): File? = chooseFile(title, initialDirectory, initialFileName, *filters.asExtensionFilters())

/**
 * Choose a file to open.
 * @param filters expected file extensions.
 * @return chosen file.
 */
inline fun Window.chooseFile(vararg filters: ExtensionFilter): File? = chooseFile(null, null, null, *filters)

/**
 * Choose a file to open.
 * @param filters expected file extensions.
 * @return chosen file.
 */
inline fun Window.chooseFile(vararg filters: Pair<String, String>): File? = chooseFile(null, null, null, *filters)

/**
 * Choose multiple files to open.
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
 * Choose multiple files to open.
 * @param title title of the dialog.
 * @param initialDirectory starting point of chooser.
 * @param initialFileName starting name of file to be choosen.
 * @param filters expected file extensions.
 * @return chosen files.
 */
inline fun Window.chooseFiles(
    title: String? = null,
    initialDirectory: File? = null,
    initialFileName: String? = null,
    vararg filters: Pair<String, String>
): List<File> = chooseFiles(title, initialDirectory, initialFileName, *filters.asExtensionFilters())

/**
 * Choose multiple files to open.
 * @param filters expected file extensions.
 * @return chosen files.
 */
inline fun Window.chooseFiles(vararg filters: ExtensionFilter): List<File> = chooseFiles(null, null, null, *filters)

/**
 * Choose multiple files to open.
 * @param filters expected file extensions.
 * @return chosen files.
 */
inline fun Window.chooseFiles(vararg filters: Pair<String, String>): List<File> =
    chooseFiles(null, null, null, *filters)

/**
 * Choose a file to save.
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
): File? = FileChooser().also {
    if (title != null) it.title = title
    if (initialDirectory != null) it.initialDirectory = initialDirectory
    if (initialFileName != null) it.initialFileName = initialFileName
    if (filters.isNotEmpty()) it.extensionFilters += filters
}.showSaveDialog(this)

/**
 * Choose a file to save.
 * @param title title of the dialog.
 * @param initialDirectory starting point of chooser.
 * @param initialFileName starting name of file to be choosen.
 * @param filters expected file extensions.
 * @return chosen file.
 */
inline fun Window.chooseSaveFile(
    title: String? = null,
    initialDirectory: File? = null,
    initialFileName: String? = null,
    vararg filters: Pair<String, String>
): File? = chooseSaveFile(title, initialDirectory, initialFileName, *filters.asExtensionFilters())

/**
 * Choose a file to save.
 * @param filters expected file extensions.
 * @return chosen file.
 */
inline fun Window.chooseSaveFile(vararg filters: ExtensionFilter): File? = chooseSaveFile(null, null, null, *filters)

/**
 * Choose a file to save.
 * @param filters expected file extensions.
 * @return chosen file.
 */
inline fun Window.chooseSaveFile(vararg filters: Pair<String, String>): File? =
    chooseSaveFile(null, null, null, *filters)

@PublishedApi
internal inline fun Array<out Pair<String, String>>.asExtensionFilters(): Array<ExtensionFilter> =
    map { ExtensionFilter(it.first, it.second) }.toTypedArray()
