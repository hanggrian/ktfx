package ktfx.styles.scene.shape

import javafx.scene.paint.Color.AQUA
import javafx.scene.paint.Color.BLUE
import javafx.scene.shape.Circle
import javafx.scene.shape.Shape
import javafx.scene.shape.StrokeLineCap.ROUND
import javafx.scene.shape.StrokeLineJoin.BEVEL
import javafx.scene.shape.StrokeType.INSIDE
import ktfx.styles.NodeTest
import ktfx.styles.shapeStyle
import kotlin.test.assertEquals

class ShapeStyleTest : NodeTest<Shape>() {

    override fun newInstance() = Circle()

    override val style: String
        get() = shapeStyle {
            fill = BLUE
            smooth = false
            stroke = AQUA
            strokeType = INSIDE
            // strokeDashArray
            strokeDashOffset = 10
            strokeLineCap = ROUND
            strokeLineJoin = BEVEL
            strokeMiterLimit = 20
            strokeWidth = 5
        }

    override fun Shape.assertion() {
        assertEquals(fill, BLUE)
        assertEquals(isSmooth, false)
        assertEquals(stroke, AQUA)
        assertEquals(strokeType, INSIDE)
        // assertEquals(strokeDashArray, )
        assertEquals(strokeDashOffset, 10.0)
        assertEquals(strokeLineCap, ROUND)
        assertEquals(strokeLineJoin, BEVEL)
        assertEquals(strokeMiterLimit, 20.0)
        assertEquals(strokeWidth, 5.0)
    }
}