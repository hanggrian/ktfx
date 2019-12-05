package ktfx.layouts.scene.shape

import javafx.scene.shape.Circle
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.circle
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CircleTest : LayoutTest<NodeManager, Circle>() {

    override fun createManager() = KtfxPane()
    override fun create() = circle { }
    override fun NodeManager.add() = circle()
    override fun NodeManager.addWithBuilder() = circle { }

    override fun Circle.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radius)
        assertNull(fill)
    }
}