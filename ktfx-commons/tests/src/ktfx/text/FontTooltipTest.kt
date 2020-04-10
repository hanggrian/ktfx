package ktfx.text

import javafx.scene.control.Tooltip
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import ktfx.test.BaseFontTest

class FontTooltipTest : BaseFontTest<Tooltip>() {

    override fun getContainer(): Tooltip = Tooltip()

    override fun Tooltip.set(font: Font) = setFont(font)

    override var Tooltip.family: String
        get() = fontFamily
        set(value) {
            fontFamily = value
        }

    override var Tooltip.weight: FontWeight
        get() = fontWeight
        set(value) {
            fontWeight = value
        }

    override var Tooltip.posture: FontPosture
        get() = fontPosture
        set(value) {
            fontPosture = value
        }

    override var Tooltip.size: Double
        get() = fontSize
        set(value) {
            fontSize = value
        }
}