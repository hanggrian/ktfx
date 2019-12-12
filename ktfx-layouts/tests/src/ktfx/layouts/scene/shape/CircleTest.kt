package ktfx.layouts.scene.shape

import javafx.scene.shape.Circle
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.circle
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CircleTest : BaseLayoutTest<NodeManager, Circle>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = circle { }
    override fun NodeManager.child2() = circle()
    override fun NodeManager.child3() = circle { }

    override fun Circle.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radius)
        assertNull(fill)
    }
}