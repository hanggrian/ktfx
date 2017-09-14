@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.kotfx.dialogs

import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser
import javafx.stage.Window
import java.io.File

/**
 * Show file chooser expecting to open single file with specified title and extension filters.
 * [action] will only execute if result is present and not null.
 */
inline fun fileChooser(
        owner: Window,
        vararg filters: FileChooser.ExtensionFilter,
        action: (File) -> Unit
) {
    val chooser = FileChooser()
    chooser.extensionFilters.addAll(*filters)
    chooser.showOpenDialog(owner)?.let(action)
}

/**
 * Show file chooser expecting to open single file with custom initialization block.
 * [action] will only execute if result is present and not null.
 */
inline fun fileChooser(
        owner: Window,
        init: FileChooser.() -> Unit,
        action: (File) -> Unit
) {
    val chooser = FileChooser()
    chooser.init()
    chooser.showOpenDialog(owner)?.let(action)
}

/**
 * Show file chooser expecting to open multiple files with specified title and extension filters.
 * [action] will only execute if result is present and not null.
 */
inline fun multipleFileChooser(
        owner: Window,
        vararg filters: FileChooser.ExtensionFilter,
        action: (List<File>) -> Unit
) {
    val chooser = FileChooser()
    chooser.extensionFilters.addAll(*filters)
    chooser.showOpenMultipleDialog(owner)?.let(action)
}

/**
 * Show file chooser expecting to open multiple files with custom initialization block.
 * [action] will only execute if result is present and not null.
 */
inline fun multipleFileChooser(
        owner: Window,
        init: FileChooser.() -> Unit,
        action: (List<File>) -> Unit
) {
    val chooser = FileChooser()
    chooser.init()
    chooser.showOpenMultipleDialog(owner)?.let(action)
}

/**
 * Show file chooser expecting to save single file with specified title and extension filters.
 * [action] will only execute if result is present and not null.
 */
inline fun saveFileChooser(
        owner: Window,
        vararg filters: FileChooser.ExtensionFilter,
        action: (File) -> Unit
) {
    val chooser = FileChooser()
    chooser.extensionFilters.addAll(*filters)
    chooser.showSaveDialog(owner)?.let(action)
}

/**
 * Show file chooser expecting to save single file with custom initialization block.
 * [action] will only execute if result is present and not null.
 */
inline fun saveFileChooser(
        owner: Window,
        init: FileChooser.() -> Unit,
        action: (File) -> Unit
) {
    val chooser = FileChooser()
    chooser.init()
    chooser.showSaveDialog(owner)?.let(action)
}

/**
 * Show file chooser expecting to open single directory with specified title.
 * [action] will only execute if result is present and not null.
 */
inline fun directoryChooser(
        owner: Window,
        action: (File) -> Unit
) {
    val chooser = DirectoryChooser()
    chooser.showDialog(owner)?.let(action)
}

/**
 * Show file chooser expecting to open single directory with custom initialization block.
 * [action] will only execute if result is present and not null.
 */
inline fun directoryChooser(
        owner: Window,
        init: DirectoryChooser.() -> Unit,
        action: (File) -> Unit
) {
    val chooser = DirectoryChooser()
    chooser.init()
    chooser.showDialog(owner)?.let(action)
}