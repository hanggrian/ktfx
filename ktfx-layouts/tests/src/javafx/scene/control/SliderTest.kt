package ktfx.layouts

import javafx.scene.control.Slider
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class SliderTest : LayoutsTest<KtfxPane, Slider>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = slider { }
    override fun KtfxPane.child2() = slider()
    override fun KtfxPane.child3() = slider { }

    override fun Slider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(100.0, max)
        assertEquals(0.0, value)
    }
}