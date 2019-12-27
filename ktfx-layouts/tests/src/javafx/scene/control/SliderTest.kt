package ktfx.layouts

import javafx.scene.control.Slider
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class SliderTest : LayoutsTest<NodeManager, Slider>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = slider { }
    override fun NodeManager.child2() = slider()
    override fun NodeManager.child3() = slider { }

    override fun Slider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(100.0, max)
        assertEquals(0.0, value)
    }
}