@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.control.TextInputControl
import javafx.scene.text.Font
import java.io.InputStream

inline fun TextInputControl.updateFont(fontBuilder: Font.() -> Unit) {
    font = font.apply { fontBuilder() }
}

inline fun TextInputControl.loadFont(url: String, size: Double = -1.0) {
    font = Font.loadFont(url, size)
}

inline fun TextInputControl.loadFont(stream: InputStream, size: Double = -1.0) {
    font = Font.loadFont(stream, size)
}