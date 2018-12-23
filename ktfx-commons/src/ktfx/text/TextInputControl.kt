@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.control.TextInputControl
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import java.io.InputStream

inline var TextInputControl.fontSize: Double
    get() = font.size
    set(value) {
        font = Font.font(value)
    }

inline var TextInputControl.fontFamily: String
    get() = font.family
    set(value) {
        font = Font.font(value)
    }

inline fun TextInputControl.font(
    size: Double = -1.0,
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null
) {
    font = Font.font(family, weight, posture, size)
}

inline fun TextInputControl.font(
    url: String,
    size: Double = -1.0
) {
    font = Font.loadFont(url, size)
}

inline fun TextInputControl.font(
    stream: InputStream,
    size: Double = -1.0
) {
    font = Font.loadFont(stream, size)
}