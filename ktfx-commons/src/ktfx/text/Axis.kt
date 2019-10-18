package ktfx.text

import java.io.InputStream
import javafx.scene.chart.Axis
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

fun Axis<*>.updateTickLabelFont(size: Double) {
    tickLabelFont = Font.font(size)
}

fun Axis<*>.updateTickLabelFont(
    family: String = "System",
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Double = -1.0
) {
    tickLabelFont = Font.font(family, weight, posture, size)
}

fun Axis<*>.loadTickLabelFont(url: String, size: Double = -1.0) {
    tickLabelFont = Font.loadFont(url, size)
}

fun Axis<*>.loadTickLabelFont(stream: InputStream, size: Double = -1.0) {
    tickLabelFont = Font.loadFont(stream, size)
}
