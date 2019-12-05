package ktfx.layouts.scene.shape

import javafx.scene.shape.Ellipse
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.ellipse
import kotlin.test.assertEquals

class EllipseTest : LayoutTest<NodeManager, Ellipse>() {

    override fun createManager() = KtfxPane()
    override fun create() = ellipse { }
    override fun NodeManager.add() = ellipse()
    override fun NodeManager.addWithBuilder() = ellipse { }

    override fun Ellipse.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radiusX)
        assertEquals(0.0, radiusY)
    }
}