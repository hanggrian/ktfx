package ktfx.layouts.scene.shape

import javafx.scene.shape.Polyline
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.polyline
import ktfx.test.assertEmpty

class PolylineTest : LayoutTest<NodeManager, Polyline>() {

    override fun createManager() = KtfxPane()
    override fun create() = polyline { }
    override fun NodeManager.add() = polyline()
    override fun NodeManager.addWithBuilder() = polyline { }

    override fun Polyline.testDefaultValues() {
        assertEmpty(points)
    }
}