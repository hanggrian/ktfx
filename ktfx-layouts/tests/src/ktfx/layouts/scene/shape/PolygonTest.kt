package ktfx.layouts.scene.shape

import javafx.scene.shape.Polygon
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.polygon
import ktfx.test.BaseLayoutTest
import ktfx.test.assertEmpty

class PolygonTest : BaseLayoutTest<NodeManager, Polygon>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = polygon { }
    override fun NodeManager.child2() = polygon()
    override fun NodeManager.child3() = polygon { }

    override fun Polygon.testDefaultValues() {
        assertEmpty(points)
    }
}