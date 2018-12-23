@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.control.Tooltip
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import java.io.InputStream

inline var Tooltip.fontSize: Double
    get() = font.size
    set(value) {
        font = Font.font(value)
    }

inline var Tooltip.fontFamily: String
    get() = font.family
    set(value) {
        font = Font.font(value)
    }

inline fun Tooltip.font(
    size: Double = -1.0,
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null
) {
    font = Font.font(family, weight, posture, size)
}

inline fun Tooltip.font(
    url: String,
    size: Double = -1.0
) {
    font = Font.loadFont(url, size)
}

inline fun Tooltip.font(
    stream: InputStream,
    size: Double = -1.0
) {
    font = Font.loadFont(stream, size)
}