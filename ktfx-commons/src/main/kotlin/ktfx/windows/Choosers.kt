@file:OptIn(ExperimentalContracts::class)

package ktfx.windows

import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser
import javafx.stage.Window
import java.io.File
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Choose a directory.
 *
 * @param configuration custom window action.
 * @return chosen directory.
 */
public inline fun Window.chooseDirectory(configuration: DirectoryChooser.() -> Unit): File? {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return DirectoryChooser()
        .apply(configuration)
        .showDialog(this)
}

/**
 * Choose a file to open.
 *
 * @param configuration custom window action.
 * @return chosen file.
 */
public inline fun Window.chooseFile(configuration: FileChooser.() -> Unit): File? {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return FileChooser()
        .apply(configuration)
        .showOpenDialog(this)
}

/**
 * Choose multiple files to open.
 *
 * @param configuration custom window action.
 * @return chosen files.
 */
public inline fun Window.chooseFiles(configuration: FileChooser.() -> Unit): List<File> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return FileChooser()
        .apply(configuration)
        .showOpenMultipleDialog(this)
}

/**
 * Choose a file to save.
 *
 * @param configuration custom window action.
 * @return chosen file.
 */
public inline fun Window.chooseSaveFile(configuration: FileChooser.() -> Unit): File? {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return FileChooser()
        .apply(configuration)
        .showSaveDialog(this)
}
