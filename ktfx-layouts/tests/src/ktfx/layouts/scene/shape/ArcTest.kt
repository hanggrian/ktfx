package ktfx.layouts.scene.shape

import javafx.scene.shape.Arc
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.arc
import kotlin.test.assertEquals

class ArcTest : LayoutTest<NodeManager, Arc>() {

    override fun createManager() = KtfxPane()
    override fun create() = arc { }
    override fun NodeManager.add() = arc()
    override fun NodeManager.addWithBuilder() = arc { }

    override fun Arc.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radiusX)
        assertEquals(0.0, radiusY)
        assertEquals(0.0, startAngle)
        assertEquals(0.0, length)
    }
}