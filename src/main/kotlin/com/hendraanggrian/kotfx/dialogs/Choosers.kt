@file:JvmMultifileClass
@file:JvmName("DialogsKt")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.kotfx.dialogs

import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser
import javafx.stage.Window
import java.io.File

/** Show file chooser expecting to open single file with specified title and extension filters. */
inline fun fileChooser(
        owner: Window,
        title: String,
        vararg filters: FileChooser.ExtensionFilter,
        action: (File) -> Unit
) {
    val chooser = FileChooser()
    chooser.title = title
    chooser.extensionFilters.addAll(*filters)
    action(chooser.showOpenDialog(owner))
}

/** Show file chooser expecting to open single file with custom initialization block. */
inline fun fileChooser(
        owner: Window,
        init: FileChooser.() -> Unit,
        action: (File) -> Unit
) {
    val chooser = FileChooser()
    chooser.init()
    action(chooser.showOpenDialog(owner))
}

/** Show file chooser expecting to open multiple files with specified title and extension filters. */
inline fun multipleFileChooser(
        owner: Window,
        title: String,
        vararg filters: FileChooser.ExtensionFilter,
        action: (List<File>) -> Unit
) {
    val chooser = FileChooser()
    chooser.title = title
    chooser.extensionFilters.addAll(*filters)
    action(chooser.showOpenMultipleDialog(owner))
}

/** Show file chooser expecting to open multiple files with custom initialization block. */
inline fun multipleFileChooser(
        owner: Window,
        init: FileChooser.() -> Unit,
        action: (List<File>) -> Unit
) {
    val chooser = FileChooser()
    chooser.init()
    action(chooser.showOpenMultipleDialog(owner))
}

/** Show file chooser expecting to save single file with specified title and extension filters. */
inline fun saveFileChooser(
        owner: Window,
        title: String,
        vararg filters: FileChooser.ExtensionFilter,
        action: (File) -> Unit
) {
    val chooser = FileChooser()
    chooser.title = title
    chooser.extensionFilters.addAll(*filters)
    action(chooser.showSaveDialog(owner))
}

/** Show file chooser expecting to save single file with custom initialization block. */
inline fun saveFileChooser(
        owner: Window,
        init: FileChooser.() -> Unit,
        action: (File) -> Unit
) {
    val chooser = FileChooser()
    chooser.init()
    action(chooser.showSaveDialog(owner))
}

/** Show file chooser expecting to open single directory with specified title. */
inline fun directoryChooser(
        owner: Window,
        title: String,
        action: (File) -> Unit
) {
    val chooser = DirectoryChooser()
    chooser.title = title
    action(chooser.showDialog(owner))
}

/** Show file chooser expecting to open single directory with custom initialization block. */
inline fun directoryChooser(
        owner: Window,
        init: DirectoryChooser.() -> Unit,
        action: (File) -> Unit
) {
    val chooser = DirectoryChooser()
    chooser.init()
    action(chooser.showDialog(owner))
}