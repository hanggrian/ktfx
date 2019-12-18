package ktfx.layouts

import javafx.scene.shape.Polyline
import ktfx.test.BaseLayoutTest
import ktfx.test.assertEmpty

class PolylineTest : BaseLayoutTest<NodeManager, Polyline>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = polyline { }
    override fun NodeManager.child2() = polyline()
    override fun NodeManager.child3() = polyline { }

    override fun Polyline.testDefaultValues() {
        assertEmpty(points)
    }
}