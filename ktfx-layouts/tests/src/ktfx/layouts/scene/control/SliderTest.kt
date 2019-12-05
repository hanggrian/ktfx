package ktfx.layouts.scene.control

import javafx.scene.control.Slider
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.slider
import kotlin.test.assertEquals

class SliderTest : LayoutTest<NodeManager, Slider>() {

    override fun createManager() = KtfxPane()
    override fun create() = slider { }
    override fun NodeManager.add() = slider()
    override fun NodeManager.addWithBuilder() = slider { }

    override fun Slider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(100.0, max)
        assertEquals(0.0, value)
    }
}