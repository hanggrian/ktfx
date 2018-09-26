@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.input

import javafx.scene.image.Image
import javafx.scene.input.Clipboard
import javafx.scene.input.DataFormat
import java.io.File

/** The content associated with this type, or null if there is none. */
inline operator fun Clipboard.get(dataFormat: DataFormat): Any? = getContent(dataFormat)

/** Executes action if string is present in this clipboard. */
fun Clipboard.ifStringPresent(action: (String) -> Unit) {
    if (hasString()) action(string)
}

/** Executes action if url is present in this clipboard. */
fun Clipboard.ifUrlPresent(action: (String) -> Unit) {
    if (hasUrl()) action(url)
}

/** Executes action if html is present in this clipboard. */
fun Clipboard.ifHtmlPresent(action: (String) -> Unit) {
    if (hasHtml()) action(html)
}

/** Executes action if rtf is present in this clipboard. */
fun Clipboard.ifRtfPresent(action: (String) -> Unit) {
    if (hasRtf()) action(rtf)
}

/** Executes action if image is present in this clipboard. */
fun Clipboard.ifImagePresent(action: (Image) -> Unit) {
    if (hasImage()) action(image)
}

/** Executes action if files is present in this clipboard. */
fun Clipboard.ifFilesPresent(action: (List<File>) -> Unit) {
    if (hasFiles()) action(files)
}