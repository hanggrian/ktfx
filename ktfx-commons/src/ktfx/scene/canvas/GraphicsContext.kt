@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.canvas

import javafx.scene.canvas.GraphicsContext
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import java.io.InputStream

inline var GraphicsContext.fontSize: Double
    get() = font.size
    set(value) {
        font = Font.font(value)
    }

inline var GraphicsContext.fontFamily: String
    get() = font.family
    set(value) {
        font = Font.font(value)
    }

inline fun GraphicsContext.font(
    size: Double = -1.0,
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null
) {
    font = Font.font(family, weight, posture, size)
}

inline fun GraphicsContext.font(
    url: String,
    size: Double = -1.0
) {
    font = Font.loadFont(url, size)
}

inline fun GraphicsContext.font(
    stream: InputStream,
    size: Double = -1.0
) {
    font = Font.loadFont(stream, size)
}