package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import org.controlsfx.control.RangeSlider
import kotlin.test.assertEquals

class RangeSliderTest : LayoutsTest<NodeManager, RangeSlider>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = rangeSlider { }
    override fun NodeManager.child2() = rangeSlider()
    override fun NodeManager.child3() = rangeSlider { }

    override fun RangeSlider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(1.0, max)
        assertEquals(0.25, lowValue)
        assertEquals(0.75, highValue)
    }
}