@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.input

import javafx.scene.image.Image
import javafx.scene.input.Clipboard
import java.io.File

/** Executes action if string is present in this clipboard. */
inline fun Clipboard.ifStringPresent(action: (String) -> Unit) {
    if (hasString()) action(string)
}

/** Executes action if url is present in this clipboard. */
inline fun Clipboard.ifUrlPresent(action: (String) -> Unit) {
    if (hasString()) action(url)
}

/** Executes action if html is present in this clipboard. */
inline fun Clipboard.ifHtmlPresent(action: (String) -> Unit) {
    if (hasString()) action(html)
}

/** Executes action if rtf is present in this clipboard. */
inline fun Clipboard.ifRtfPresent(action: (String) -> Unit) {
    if (hasString()) action(rtf)
}

/** Executes action if image is present in this clipboard. */
inline fun Clipboard.ifImagePresent(action: (Image) -> Unit) {
    if (hasString()) action(image)
}

/** Executes action if files is present in this clipboard. */
inline fun Clipboard.ifFilesPresent(action: (List<File>) -> Unit) {
    if (hasString()) action(files)
}