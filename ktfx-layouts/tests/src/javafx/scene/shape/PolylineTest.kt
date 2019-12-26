package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.shape.Polyline
import ktfx.test.LayoutTest

class PolylineTest : LayoutTest<NodeManager, Polyline>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = polyline { }
    override fun NodeManager.child2() = polyline()
    override fun NodeManager.child3() = polyline { }

    override fun Polyline.testDefaultValues() {
        assertThat(points).isEmpty()
    }
}