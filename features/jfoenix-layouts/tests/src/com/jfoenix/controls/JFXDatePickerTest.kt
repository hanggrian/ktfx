package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDatePicker
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class JFXDatePickerTest : LayoutTest<NodeManager, JFXDatePicker>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxDatePicker { }
    override fun NodeManager.child2() = jfxDatePicker()
    override fun NodeManager.child3() = jfxDatePicker { }

    override fun JFXDatePicker.testDefaultValues() {
        assertNull(value)
    }
}