@file:Suppress("NOTHING_TO_INLINE")

package javafxx.scene.input

import javafx.scene.image.Image
import javafx.scene.input.ClipboardContent
import java.io.File

/** Executes action if string is present in this clipboard content. */
inline fun ClipboardContent.ifStringPresent(action: (String) -> Unit) {
    if (hasString()) action(string)
}

/** Executes action if url is present in this clipboard content. */
inline fun ClipboardContent.ifUrlPresent(action: (String) -> Unit) {
    if (hasUrl()) action(url)
}

/** Executes action if html is present in this clipboard content. */
inline fun ClipboardContent.ifHtmlPresent(action: (String) -> Unit) {
    if (hasHtml()) action(html)
}

/** Executes action if rtf is present in this clipboard content. */
inline fun ClipboardContent.ifRtfPresent(action: (String) -> Unit) {
    if (hasRtf()) action(rtf)
}

/** Executes action if image is present in this clipboard content. */
inline fun ClipboardContent.ifImagePresent(action: (Image) -> Unit) {
    if (hasImage()) action(image)
}

/** Executes action if files is present in this clipboard content. */
inline fun ClipboardContent.ifFilesPresent(action: (List<File>) -> Unit) {
    if (hasFiles()) action(files)
}