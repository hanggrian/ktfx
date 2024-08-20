package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.geometry.Orientation
import javafx.scene.layout.FlowPane
import ktfx.controls.insetsOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class FlowPaneTest : LayoutsStyledTest<KtfxPane, FlowPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = flowPane {}

    override fun KtfxPane.child2() = flowPane()

    override fun child3() = styledFlowPane()

    override fun KtfxPane.child4() = styledFlowPane()

    override fun FlowPane.testDefaultValues() {
        assertEquals(Orientation.HORIZONTAL, orientation)
        assertEquals(0.0, hgap)
        assertEquals(0.0, vgap)
    }

    @Test
    fun margin() {
        flowPane {
            val region = region()

            region.margin(insetsOf(1.0))
            assertEquals(1.0, region.margin!!.top)
            assertEquals(1.0, region.margin!!.right)
            assertEquals(1.0, region.margin!!.bottom)
            assertEquals(1.0, region.margin!!.left)
            region.clearConstraints()

            region.margin = insetsOf(2.0)
            assertEquals(2.0, region.margin!!.top)
            assertEquals(2.0, region.margin!!.right)
            assertEquals(2.0, region.margin!!.bottom)
            assertEquals(2.0, region.margin!!.left)
            region.clearConstraints()

            assertNull(region.margin)
        }
    }
}
