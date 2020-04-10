package ktfx.text

import javafx.scene.control.Label
import javafx.scene.control.Labeled
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import ktfx.test.BaseFontTest

class FontLabeledTest : BaseFontTest<Labeled>() {

    override fun getContainer(): Labeled = Label()

    override fun Labeled.set(font: Font) = setFont(font)

    override var Labeled.family: String
        get() = fontFamily
        set(value) {
            fontFamily = value
        }

    override var Labeled.weight: FontWeight
        get() = fontWeight
        set(value) {
            fontWeight = value
        }

    override var Labeled.posture: FontPosture
        get() = fontPosture
        set(value) {
            fontPosture = value
        }

    override var Labeled.size: Double
        get() = fontSize
        set(value) {
            fontSize = value
        }
}