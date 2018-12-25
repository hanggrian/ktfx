@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.control.Tooltip
import javafx.scene.text.Font
import java.io.InputStream

inline fun Tooltip.updateFont(fontBuilder: Font.() -> Unit) {
    font = font.apply { fontBuilder() }
}

inline fun Tooltip.loadFont(url: String, size: Double = -1.0) {
    font = Font.loadFont(url, size)
}

inline fun Tooltip.loadFont(stream: InputStream, size: Double = -1.0) {
    font = Font.loadFont(stream, size)
}