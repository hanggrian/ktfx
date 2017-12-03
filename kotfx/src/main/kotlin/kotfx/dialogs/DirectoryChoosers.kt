@file:JvmMultifileClass
@file:JvmName("ChoosersKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.stage.DirectoryChooser

/** Creates a directory chooser dialog with title and optional initialization block. */
@JvmOverloads
inline fun directoryChooser(
        title: String,
        noinline init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser = DirectoryChooser().apply {
    this.title = title
    init?.invoke(this)
}

/** Creates a directory chooser dialog with optional initialization block. */
@JvmOverloads
inline fun directoryChooser(
        noinline init: (DirectoryChooser.() -> Unit)? = null
): DirectoryChooser = DirectoryChooser().apply {
    init?.invoke(this)
}