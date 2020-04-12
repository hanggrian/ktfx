package ktfx.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import ktfx.test.BaseFontTest
import kotlin.test.Ignore

@Ignore
class FontTextTest : BaseFontTest<Text>() {

    override fun getContainer(): Text = Text()

    override fun Text.set(font: Font) = setFont(font)

    override var Text.family: String
        get() = fontFamily
        set(value) {
            fontFamily = value
        }

    override var Text.weight: FontWeight
        get() = fontWeight
        set(value) {
            fontWeight = value
        }

    override var Text.posture: FontPosture
        get() = fontPosture
        set(value) {
            fontPosture = value
        }

    override var Text.size: Double
        get() = fontSize
        set(value) {
            fontSize = value
        }
}