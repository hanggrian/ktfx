package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXColorPicker
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXColorPickerTest : LayoutsTest<NodeManager, JFXColorPicker>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxColorPicker { }
    override fun NodeManager.child2() = jfxColorPicker()
    override fun NodeManager.child3() = jfxColorPicker { }

    override fun JFXColorPicker.testDefaultValues() {
        assertNull(value)
    }
}