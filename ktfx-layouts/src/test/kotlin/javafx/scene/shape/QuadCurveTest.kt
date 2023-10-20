package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.QuadCurve
import kotlin.test.assertEquals

class QuadCurveTest : LayoutsTest<KtfxPane, QuadCurve>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): QuadCurve = quadCurve { }

    override fun KtfxPane.child2(): QuadCurve = quadCurve()

    override fun KtfxPane.child3(): QuadCurve = quadCurve { }

    override fun QuadCurve.testDefaultValues() {
        assertEquals(0.0, startX)
        assertEquals(0.0, startY)
        assertEquals(0.0, controlX)
        assertEquals(0.0, controlY)
        assertEquals(0.0, endX)
        assertEquals(0.0, endY)
    }
}
