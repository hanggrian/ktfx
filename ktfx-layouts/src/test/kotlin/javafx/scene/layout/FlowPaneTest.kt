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

    override fun child3() = styledFlowPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledFlowPane(styleClass = arrayOf("style"))

    override fun FlowPane.testDefaultValues() {
        assertEquals(Orientation.HORIZONTAL, orientation)
        assertEquals(0.0, hgap)
        assertEquals(0.0, vgap)
    }

    @Test
    fun margins() {
        flowPane {
            val region1 = region().margin(insetsOf(5))
            assertEquals(5.0, region1.margin!!.top)
            assertEquals(5.0, region1.margin!!.right)
            assertEquals(5.0, region1.margin!!.bottom)
            assertEquals(5.0, region1.margin!!.left)
            val region2 = region().margin(insetsOf(top = 10, right = 20, bottom = 30, left = 40))
            assertEquals(10.0, region2.margin!!.top)
            assertEquals(20.0, region2.margin!!.right)
            assertEquals(30.0, region2.margin!!.bottom)
            assertEquals(40.0, region2.margin!!.left)
            val region3 = region().margin(insetsOf(vertical = 10, horizontal = 20))
            assertEquals(10.0, region3.margin!!.top)
            assertEquals(20.0, region3.margin!!.right)
            assertEquals(10.0, region3.margin!!.bottom)
            assertEquals(20.0, region3.margin!!.left)

            region1.clearConstraints()
            assertNull(region1.margin)
            region2.clearConstraints()
            assertNull(region2.margin)
            region3.clearConstraints()
            assertNull(region3.margin)

            assertEquals(children.size, 3)
        }
    }
}
