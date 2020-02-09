package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXColorPicker
import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXColorPickerTest : LayoutsTest<KtfxPane, JFXColorPicker>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxColorPicker { }
    override fun KtfxPane.child2() = jfxColorPicker()
    override fun KtfxPane.child3() = jfxColorPicker { }

    override fun JFXColorPicker.testDefaultValues() {
        assertNull(value)
    }
}