package ktfx.layouts.scene.shape

import javafx.scene.shape.Polyline
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.polyline
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty

class PolylineTest : LayoutTest<NodeManager, Polyline>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = polyline { }
    override fun NodeManager.child2() = polyline()
    override fun NodeManager.child3() = polyline { }

    override fun Polyline.testDefaultValues() {
        assertEmpty(points)
    }
}