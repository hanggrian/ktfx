package ktfx.text

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import ktfx.test.BaseFontTest

class FontGraphicsContextTest : BaseFontTest<GraphicsContext>() {

    override fun getContainer(): GraphicsContext = Canvas().graphicsContext2D

    override fun GraphicsContext.set(font: Font) = setFont(font)

    override var GraphicsContext.family: String
        get() = fontFamily
        set(value) {
            fontFamily = value
        }

    override var GraphicsContext.weight: FontWeight
        get() = fontWeight
        set(value) {
            fontWeight = value
        }

    override var GraphicsContext.posture: FontPosture
        get() = fontPosture
        set(value) {
            fontPosture = value
        }

    override var GraphicsContext.size: Double
        get() = fontSize
        set(value) {
            fontSize = value
        }
}