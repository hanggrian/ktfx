package ktfx.text

import javafx.scene.control.TextField
import javafx.scene.control.TextInputControl
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import ktfx.test.BaseFontTest
import kotlin.test.Ignore

@Ignore
class FontTextInputControlTest : BaseFontTest<TextInputControl>() {

    override fun getContainer(): TextInputControl = TextField()

    override fun TextInputControl.set(font: Font) = setFont(font)

    override var TextInputControl.family: String
        get() = fontFamily
        set(value) {
            fontFamily = value
        }

    override var TextInputControl.weight: FontWeight
        get() = fontWeight
        set(value) {
            fontWeight = value
        }

    override var TextInputControl.posture: FontPosture
        get() = fontPosture
        set(value) {
            fontPosture = value
        }

    override var TextInputControl.size: Double
        get() = fontSize
        set(value) {
            fontSize = value
        }
}