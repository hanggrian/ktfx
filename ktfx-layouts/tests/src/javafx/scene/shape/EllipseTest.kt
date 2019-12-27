package ktfx.layouts

import javafx.scene.shape.Ellipse
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class EllipseTest : LayoutsTest<NodeManager, Ellipse>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = ellipse { }
    override fun NodeManager.child2() = ellipse()
    override fun NodeManager.child3() = ellipse { }

    override fun Ellipse.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radiusX)
        assertEquals(0.0, radiusY)
    }
}