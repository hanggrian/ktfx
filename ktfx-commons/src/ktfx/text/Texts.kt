@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.text.Font
import javafx.scene.text.Text
import java.io.InputStream

inline fun Text.updateFont(fontBuilder: Font.() -> Unit) {
    font = font.apply { fontBuilder() }
}

inline fun Text.loadFont(url: String, size: Double = -1.0) {
    font = Font.loadFont(url, size)
}

inline fun Text.loadFont(stream: InputStream, size: Double = -1.0) {
    font = Font.loadFont(stream, size)
}