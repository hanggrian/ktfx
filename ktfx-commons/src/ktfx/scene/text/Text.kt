@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import java.io.InputStream

inline var Text.fontSize: Double
    get() = font.size
    set(value) {
        font = Font.font(value)
    }

inline var Text.fontFamily: String
    get() = font.family
    set(value) {
        font = Font.font(value)
    }

inline fun Text.font(
    size: Double = -1.0,
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null
) {
    font = Font.font(family, weight, posture, size)
}

inline fun Text.font(
    url: String,
    size: Double = -1.0
) {
    font = Font.loadFont(url, size)
}

inline fun Text.font(
    stream: InputStream,
    size: Double = -1.0
) {
    font = Font.loadFont(stream, size)
}