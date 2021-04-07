package ktfx.layouts

import javafx.scene.shape.QuadCurve
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class QuadCurveTest : LayoutsTest<KtfxPane, QuadCurve>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = quadCurve { }
    override fun KtfxPane.child2() = quadCurve()
    override fun KtfxPane.child3() = quadCurve { }

    override fun QuadCurve.testDefaultValues() {
        assertEquals(0.0, startX)
        assertEquals(0.0, startY)
        assertEquals(0.0, controlX)
        assertEquals(0.0, controlY)
        assertEquals(0.0, endX)
        assertEquals(0.0, endY)
    }
}