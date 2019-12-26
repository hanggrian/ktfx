package ktfx.layouts

import javafx.scene.shape.Polyline
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