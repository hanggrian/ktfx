package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.Slider
import kotlin.test.assertEquals

class SliderTest : LayoutsTest<KtfxPane, Slider>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): Slider = slider { }
    override fun KtfxPane.child2(): Slider = slider()
    override fun KtfxPane.child3(): Slider = slider { }

    override fun Slider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(100.0, max)
        assertEquals(0.0, value)
    }
}
