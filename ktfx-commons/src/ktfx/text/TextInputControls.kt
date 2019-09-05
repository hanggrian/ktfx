package ktfx.text

import java.io.InputStream
import javafx.scene.control.TextInputControl
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

fun TextInputControl.updateFont(size: Number) {
    font = Font.font(size.toDouble())
}

fun TextInputControl.updateFont(
    family: String = "System",
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) {
    font = Font.font(family, weight, posture, size.toDouble())
}

fun TextInputControl.loadFont(url: String, size: Number = -1) {
    font = Font.loadFont(url, size.toDouble())
}

fun TextInputControl.loadFont(stream: InputStream, size: Number = -1) {
    font = Font.loadFont(stream, size.toDouble())
}
