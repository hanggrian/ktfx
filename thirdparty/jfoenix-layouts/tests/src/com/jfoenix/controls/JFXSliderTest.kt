package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSlider
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class JFXSliderTest : LayoutsTest<KtfxPane, JFXSlider>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxSlider { }
    override fun KtfxPane.child2() = jfxSlider()
    override fun KtfxPane.child3() = jfxSlider { }

    override fun JFXSlider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(100.0, max)
        assertEquals(50.0, value)
    }
}