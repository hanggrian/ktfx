@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.canvas.GraphicsContext
import javafx.scene.text.Font
import java.io.InputStream

inline fun GraphicsContext.updateFont(fontBuilder: Font.() -> Unit) {
    font = font.apply { fontBuilder() }
}

inline fun GraphicsContext.loadFont(url: String, size: Double = -1.0) {
    font = Font.loadFont(url, size)
}

inline fun GraphicsContext.loadFont(stream: InputStream, size: Double = -1.0) {
    font = Font.loadFont(stream, size)
}