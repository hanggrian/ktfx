@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import java.io.InputStream
import javafx.scene.chart.Axis
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

fun Axis<*>.updateTickLabelFont(size: Number) {
    tickLabelFont = Font.font(size.toDouble())
}

fun Axis<*>.updateTickLabelFont(
    family: String = "System",
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) {
    tickLabelFont = Font.font(family, weight, posture, size.toDouble())
}

fun Axis<*>.loadTickLabelFont(url: String, size: Number = -1) {
    tickLabelFont = Font.loadFont(url, size.toDouble())
}

fun Axis<*>.loadTickLabelFont(stream: InputStream, size: Number = -1) {
    tickLabelFont = Font.loadFont(stream, size.toDouble())
}
