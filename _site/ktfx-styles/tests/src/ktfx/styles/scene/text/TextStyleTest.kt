package ktfx.styles.scene.text

import javafx.geometry.VPos.TOP
import javafx.scene.text.FontPosture.ITALIC
import javafx.scene.text.FontSmoothingType.LCD
import javafx.scene.text.FontWeight.BOLD
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment.RIGHT
import ktfx.styles.NodeTest
import ktfx.styles.textStyle
import kotlin.test.assertEquals

class TextStyleTest : NodeTest<Text>() {

    override fun newInstance() = Text("Hello world")

    override val style: String
        get() = textStyle(true) {
            // font
            fontFamily = "Arial"
            fontSize = 20
            fontStyle = ITALIC
            fontWeight = BOLD
            fontSmoothingType = LCD
            strikethrough = true
            textAlignment = RIGHT
            textOrigin = TOP
            underline = true
        }

    override fun Text.assertion() {
        assertEquals(font.family, "Arial")
        assertEquals(font.size, 20.0)
        assertEquals(fontSmoothingType, LCD)
        assertEquals(isStrikethrough, true)
        assertEquals(textAlignment, RIGHT)
        assertEquals(textOrigin, TOP)
        assertEquals(isUnderline, true)
    }
}