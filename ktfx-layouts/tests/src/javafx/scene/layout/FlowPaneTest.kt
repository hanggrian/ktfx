package ktfx.layouts

import javafx.geometry.Orientation
import javafx.scene.layout.FlowPane
import ktfx.test.LayoutsTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class FlowPaneTest : LayoutsTest<NodeManager, FlowPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = flowPane { }
    override fun NodeManager.child2() = flowPane()
    override fun NodeManager.child3() = flowPane { }

    override fun FlowPane.testDefaultValues() {
        assertEquals(Orientation.HORIZONTAL, orientation)
        assertEquals(0.0, hgap)
        assertEquals(0.0, vgap)
    }

    @Test fun margins() {
        flowPane {
            val region1 = region() allMargin 0.0
            assertEquals(0.0, region1.topMargin)
            assertEquals(0.0, region1.rightMargin)
            assertEquals(0.0, region1.bottomMargin)
            assertEquals(0.0, region1.leftMargin)
            val region2 = region() topMargin 10.0 rightMargin 20.0 bottomMargin 30.0 leftMargin 40.0
            assertEquals(10.0, region2.topMargin)
            assertEquals(20.0, region2.rightMargin)
            assertEquals(30.0, region2.bottomMargin)
            assertEquals(40.0, region2.leftMargin)

            region1.clearConstraints()
            assertNull(region1.margin)
            region2.clearConstraints()
            assertNull(region2.margin)

            assertEquals(children.size, 2)
        }
    }
}