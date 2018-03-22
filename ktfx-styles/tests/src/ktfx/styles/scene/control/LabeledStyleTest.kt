package ktfx.styles.scene.control

import javafx.geometry.Insets
import javafx.geometry.Pos.TOP_RIGHT
import javafx.scene.control.Label
import javafx.scene.control.Labeled
import javafx.scene.control.OverrunStyle.CLIP
import javafx.scene.paint.Color.BLUE
import javafx.scene.text.TextAlignment.RIGHT
import ktfx.styles.NodeTest
import ktfx.styles.labeledStyle
import kotlin.test.assertEquals

class LabeledStyleTest : NodeTest<Labeled>() {

    override fun newInstance() = Label("Hello world")

    override val style: String
        get() = labeledStyle {
            alignment = TOP_RIGHT
            textAlignment = RIGHT
            textOverrun = CLIP
            wrapText = true
            // font
            underline = true
            // graphic = Url("test.png")
            // contentDisplay = TOP
            graphicTextGap = 10
            labelPadding = Insets(1.0, 2.0, 3.0, 4.0)
            textFill = BLUE
            // ellipsisString
        }

    override fun Labeled.assertion() {
        assertEquals(alignment, TOP_RIGHT)
        assertEquals(textAlignment, RIGHT)
        assertEquals(textOverrun, CLIP)
        assertEquals(isWrapText, true)
        assertEquals(isUnderline, true)
        // assertNotNull(graphic)
        // assertEquals(contentDisplay, TOP)
        assertEquals(graphicTextGap, 10.0)
        assertEquals(labelPadding, Insets(1.0, 2.0, 3.0, 4.0))
        assertEquals(textFill, BLUE)
    }
}