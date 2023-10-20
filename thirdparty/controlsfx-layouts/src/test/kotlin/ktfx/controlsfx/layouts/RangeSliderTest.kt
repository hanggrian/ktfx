package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.RangeSlider
import kotlin.test.assertEquals

class RangeSliderTest : LayoutsTest<KtfxPane, RangeSlider>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): RangeSlider = rangeSlider { }

    override fun KtfxPane.child2(): RangeSlider = rangeSlider()

    override fun KtfxPane.child3(): RangeSlider = rangeSlider { }

    override fun RangeSlider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(1.0, max)
        assertEquals(0.25, lowValue)
        assertEquals(0.75, highValue)
    }
}
