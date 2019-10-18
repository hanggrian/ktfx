package ktfx.text

import java.io.InputStream
import javafx.scene.canvas.GraphicsContext
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

fun GraphicsContext.updateFont(size: Double) {
    font = Font.font(size)
}

fun GraphicsContext.updateFont(
    family: String = "System",
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Double = -1.0
) {
    font = Font.font(family, weight, posture, size)
}

fun GraphicsContext.loadFont(url: String, size: Double = -1.0) {
    font = Font.loadFont(url, size)
}

fun GraphicsContext.loadFont(stream: InputStream, size: Double = -1.0) {
    font = Font.loadFont(stream, size)
}
