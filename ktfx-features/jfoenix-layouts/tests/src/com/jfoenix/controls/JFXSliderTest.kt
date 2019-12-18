package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSlider
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class JFXSliderTest : BaseLayoutTest<NodeManager, JFXSlider>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxSlider { }
    override fun NodeManager.child2() = jfxSlider()
    override fun NodeManager.child3() = jfxSlider { }

    override fun JFXSlider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(100.0, max)
        assertEquals(50.0, value)
    }
}