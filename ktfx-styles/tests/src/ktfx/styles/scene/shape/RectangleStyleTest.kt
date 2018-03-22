package ktfx.styles.scene.shape

import javafx.scene.shape.Rectangle
import ktfx.styles.NodeTest
import ktfx.styles.rectangleStyle
import kotlin.test.assertEquals

class RectangleStyleTest : NodeTest<Rectangle>() {

    override fun newInstance() = Rectangle()

    override val style: String
        get() = rectangleStyle {
            arcHeight = 10
            arcWidth = 20
        }

    override fun Rectangle.assertion() {
        assertEquals(arcHeight, 10.0)
        assertEquals(arcWidth, 20.0)
    }
}