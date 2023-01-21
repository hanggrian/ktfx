package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXSlider
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxSliderTest : LayoutsTest<KtfxPane, JFXSlider>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXSlider = jfxSlider { }
    override fun KtfxPane.child2(): JFXSlider = jfxSlider()
    override fun KtfxPane.child3(): JFXSlider = jfxSlider { }

    override fun JFXSlider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(100.0, max)
        assertEquals(50.0, value)
    }
}
