package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTimePicker
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class JFXTimePickerTest : BaseLayoutTest<NodeManager, JFXTimePicker>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxTimePicker { }
    override fun NodeManager.child2() = jfxTimePicker()
    override fun NodeManager.child3() = jfxTimePicker { }

    override fun JFXTimePicker.testDefaultValues() {
        assertNull(value)
    }
}