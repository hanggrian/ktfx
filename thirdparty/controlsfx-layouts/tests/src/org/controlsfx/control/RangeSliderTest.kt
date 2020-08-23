package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.RangeSlider
import kotlin.test.assertEquals

class RangeSliderTest : LayoutsTest<KtfxPane, RangeSlider>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = rangeSlider { }
    override fun KtfxPane.child2() = rangeSlider()
    override fun KtfxPane.child3() = rangeSlider { }

    override fun RangeSlider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(1.0, max)
        assertEquals(0.25, lowValue)
        assertEquals(0.75, highValue)
    }
}