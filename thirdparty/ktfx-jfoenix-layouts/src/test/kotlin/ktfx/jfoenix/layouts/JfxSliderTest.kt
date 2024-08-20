package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXSlider
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxSliderTest : LayoutsStyledTest<KtfxPane, JFXSlider>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxSlider {}

    override fun KtfxPane.child2() = jfxSlider()

    override fun child3() = styledJfxSlider()

    override fun KtfxPane.child4() = styledJfxSlider()

    override fun JFXSlider.testDefaultValues() {
        assertEquals(0.0, min)
        assertEquals(100.0, max)
        assertEquals(50.0, value)
    }
}
