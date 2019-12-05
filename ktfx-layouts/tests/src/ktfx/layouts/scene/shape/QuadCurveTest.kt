package ktfx.layouts.scene.shape

import javafx.scene.shape.QuadCurve
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.quadCurve
import kotlin.test.assertEquals

class QuadCurveTest : LayoutTest<NodeManager, QuadCurve>() {

    override fun createManager() = KtfxPane()
    override fun create() = quadCurve { }
    override fun NodeManager.add() = quadCurve()
    override fun NodeManager.addWithBuilder() = quadCurve { }

    override fun QuadCurve.testDefaultValues() {
        assertEquals(0.0, startX)
        assertEquals(0.0, startY)
        assertEquals(0.0, controlX)
        assertEquals(0.0, controlY)
        assertEquals(0.0, endX)
        assertEquals(0.0, endY)
    }
}