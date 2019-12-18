package ktfx.layouts

import javafx.scene.shape.QuadCurve
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class QuadCurveTest : BaseLayoutTest<NodeManager, QuadCurve>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = quadCurve { }
    override fun NodeManager.child2() = quadCurve()
    override fun NodeManager.child3() = quadCurve { }

    override fun QuadCurve.testDefaultValues() {
        assertEquals(0.0, startX)
        assertEquals(0.0, startY)
        assertEquals(0.0, controlX)
        assertEquals(0.0, controlY)
        assertEquals(0.0, endX)
        assertEquals(0.0, endY)
    }
}