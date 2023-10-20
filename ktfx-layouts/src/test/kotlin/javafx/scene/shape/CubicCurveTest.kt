package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.CubicCurve
import kotlin.test.assertEquals

class CubicCurveTest : LayoutsTest<KtfxPane, CubicCurve>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): CubicCurve = cubicCurve { }

    override fun KtfxPane.child2(): CubicCurve = cubicCurve()

    override fun KtfxPane.child3(): CubicCurve = cubicCurve { }

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
