@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.chart

import javafx.scene.chart.Axis
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import java.io.InputStream

inline var Axis<*>.tickLabelFontSize: Double
    get() = tickLabelFont.size
    set(value) {
        tickLabelFont = Font.font(value)
    }

inline var Axis<*>.tickLabelFontFamily: String
    get() = tickLabelFont.family
    set(value) {
        tickLabelFont = Font.font(value)
    }

inline fun Axis<*>.tickLabelFont(
    size: Double = -1.0,
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null
) {
    tickLabelFont = Font.font(family, weight, posture, size)
}

inline fun Axis<*>.tickLabelFont(
    url: String,
    size: Double = -1.0
) {
    tickLabelFont = Font.loadFont(url, size)
}

inline fun Axis<*>.tickLabelFont(
    stream: InputStream,
    size: Double = -1.0
) {
    tickLabelFont = Font.loadFont(stream, size)
}