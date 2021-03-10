package ktfx.layouts

import javafx.scene.shape.CubicCurve
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class CubicCurveTest : LayoutsTest<KtfxPane, CubicCurve>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = cubicCurve { }
    override fun KtfxPane.child2() = cubicCurve()
    override fun KtfxPane.child3() = cubicCurve { }

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