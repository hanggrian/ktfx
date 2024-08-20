package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Slider
import kotlin.test.assertEquals

class SliderTest : LayoutsStyledTest<KtfxPane, Slider>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = slider {}

    override fun KtfxPane.child2() = slider()

    override fun child3() = styledSlider()

    override fun KtfxPane.child4() = styledSlider()

    override fun Slider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(100.0, max)
        assertEquals(0.0, value)
    }
}
