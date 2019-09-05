package ktfx.text

import java.io.InputStream
import javafx.scene.canvas.GraphicsContext
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

fun GraphicsContext.updateFont(size: Number) {
    font = Font.font(size.toDouble())
}

fun GraphicsContext.updateFont(
    family: String = "System",
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) {
    font = Font.font(family, weight, posture, size.toDouble())
}

fun GraphicsContext.loadFont(url: String, size: Number = -1) {
    font = Font.loadFont(url, size.toDouble())
}

fun GraphicsContext.loadFont(stream: InputStream, size: Number = -1) {
    font = Font.loadFont(stream, size.toDouble())
}
