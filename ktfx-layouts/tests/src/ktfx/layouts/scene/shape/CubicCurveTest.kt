package ktfx.layouts.scene.shape

import javafx.scene.shape.CubicCurve
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.cubicCurve
import kotlin.test.assertEquals

class CubicCurveTest : LayoutTest<NodeManager, CubicCurve>() {

    override fun createManager() = KtfxPane()
    override fun create() = cubicCurve { }
    override fun NodeManager.add() = cubicCurve()
    override fun NodeManager.addWithBuilder() = cubicCurve { }

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