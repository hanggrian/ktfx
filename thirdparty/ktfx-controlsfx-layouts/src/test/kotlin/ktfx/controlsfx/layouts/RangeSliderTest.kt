package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.RangeSlider
import kotlin.test.assertEquals

class RangeSliderTest : LayoutsStyledTest<KtfxPane, RangeSlider>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = rangeSlider {}

    override fun KtfxPane.child2() = rangeSlider()

    override fun child3() = styledRangeSlider(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledRangeSlider(styleClass = arrayOf("style"))

    override fun RangeSlider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(1.0, max)
        assertEquals(0.25, lowValue)
        assertEquals(0.75, highValue)
    }
}
