package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.CubicCurve
import kotlin.test.assertEquals

class CubicCurveTest : LayoutsStyledTest<KtfxPane, CubicCurve>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = cubicCurve {}

    override fun KtfxPane.child2() = cubicCurve()

    override fun child3() = styledCubicCurve(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledCubicCurve(styleClass = arrayOf("style"))

    override fun CubicCurve.testDefaultValues() {
        assertEquals(0.0, startX)
        assertEquals(0.0, startY)
        assertEquals(0.0, controlX1)
        assertEquals(0.0, controlX2)
        assertEquals(0.0, controlY1)
        assertEquals(0.0, controlY2)
        assertEquals(0.0, endX)
        assertEquals(0.0, endY)
    }
}
