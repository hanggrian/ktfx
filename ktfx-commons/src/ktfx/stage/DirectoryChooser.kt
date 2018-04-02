@file:Suppress("NOTHING_TO_INLINE")

package ktfx.stage

import javafx.stage.DirectoryChooser

/**
 * Build a directory chooser dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 */
inline fun directoryChooser(
    title: String? = null
): DirectoryChooser = directoryChooser(title) { }

/**
 * Build a directory chooser dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param init custom initialization block.
 */
fun directoryChooser(
    title: String? = null,
    init: DirectoryChooser.() -> Unit
): DirectoryChooser = DirectoryChooser().also {
    if (title != null) it.title = title
    it.init()
}