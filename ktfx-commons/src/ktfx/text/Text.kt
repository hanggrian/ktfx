package ktfx.text

import java.io.InputStream
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text

fun Text.updateFont(size: Double) {
    font = Font.font(size)
}

fun Text.updateFont(
    family: String = "System",
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Double = -1.0
) {
    font = Font.font(family, weight, posture, size)
}

fun Text.loadFont(url: String, size: Double = -1.0) {
    font = Font.loadFont(url, size)
}

fun Text.loadFont(stream: InputStream, size: Double = -1.0) {
    font = Font.loadFont(stream, size)
}
