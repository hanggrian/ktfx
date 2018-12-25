@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.chart.Axis
import javafx.scene.text.Font
import java.io.InputStream

inline fun Axis<*>.updateTickLabelFont(fontBuilder: Font.() -> Unit) {
    tickLabelFont = tickLabelFont.apply { fontBuilder() }
}

inline fun Axis<*>.loadTickLabelFont(url: String, size: Double = -1.0) {
    tickLabelFont = Font.loadFont(url, size)
}

inline fun Axis<*>.loadTickLabelFont(stream: InputStream, size: Double = -1.0) {
    tickLabelFont = Font.loadFont(stream, size)
}