package ktfx.layouts.scene.shape

import javafx.scene.shape.Polygon
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.polygon
import ktfx.test.assertEmpty

class PolygonTest : LayoutTest<NodeManager, Polygon>() {

    override fun createManager() = KtfxPane()
    override fun create() = polygon { }
    override fun NodeManager.add() = polygon()
    override fun NodeManager.addWithBuilder() = polygon { }

    override fun Polygon.testDefaultValues() {
        assertEmpty(points)
    }
}