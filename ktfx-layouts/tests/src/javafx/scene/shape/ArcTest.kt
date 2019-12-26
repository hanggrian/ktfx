package ktfx.layouts

import javafx.scene.shape.Arc
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class ArcTest : LayoutTest<NodeManager, Arc>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = arc { }
    override fun NodeManager.child2() = arc()
    override fun NodeManager.child3() = arc { }

    override fun Arc.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radiusX)
        assertEquals(0.0, radiusY)
        assertEquals(0.0, startAngle)
        assertEquals(0.0, length)
    }
}