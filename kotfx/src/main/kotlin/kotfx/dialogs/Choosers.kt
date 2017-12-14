@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser
import javafx.stage.Window
import kotfx.internal.DialogDsl
import java.io.File

@JvmOverloads
inline fun Window.fileChooser(
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: ((@DialogDsl FileChooser).() -> Unit)? = null
): File? = FileChooser().apply {
    extensionFilters.addAll(*filters)
    init?.invoke(this)
}.showOpenDialog(this@fileChooser)

@JvmOverloads
inline fun Window.fileChooser(
        description: String,
        vararg extensions: String,
        noinline init: ((@DialogDsl FileChooser).() -> Unit)? = null
): File? = fileChooser(FileChooser.ExtensionFilter(description, *extensions), init = init)

@JvmOverloads
inline fun Window.multipleFileChooser(
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: ((@DialogDsl FileChooser).() -> Unit)? = null
): List<File>? = FileChooser().apply {
    extensionFilters.addAll(*filters)
    init?.invoke(this)
}.showOpenMultipleDialog(this@multipleFileChooser)

@JvmOverloads
inline fun Window.multipleFileChooser(
        description: String,
        vararg extensions: String,
        noinline init: ((@DialogDsl FileChooser).() -> Unit)? = null
): List<File>? = multipleFileChooser(FileChooser.ExtensionFilter(description, *extensions), init = init)

@JvmOverloads
inline fun Window.saveFileChooser(
        vararg filters: FileChooser.ExtensionFilter,
        noinline init: ((@DialogDsl FileChooser).() -> Unit)? = null
): File? = FileChooser().apply {
    extensionFilters.addAll(*filters)
    init?.invoke(this)
}.showSaveDialog(this@saveFileChooser)

@JvmOverloads
inline fun Window.saveFileChooser(
        description: String,
        vararg extensions: String,
        noinline init: ((@DialogDsl FileChooser).() -> Unit)? = null
): File? = saveFileChooser(FileChooser.ExtensionFilter(description, *extensions), init = init)

@JvmOverloads
inline fun Window.directoryChooser(
        noinline init: ((@DialogDsl DirectoryChooser).() -> Unit)? = null
): File? = DirectoryChooser().apply { init?.invoke(this) }.showDialog(this@directoryChooser)