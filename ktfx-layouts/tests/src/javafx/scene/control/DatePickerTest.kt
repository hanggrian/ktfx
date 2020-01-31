package ktfx.layouts

import javafx.scene.control.DatePicker
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class DatePickerTest : LayoutsTest<NodeManager, DatePicker>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = datePicker { }
    override fun NodeManager.child2() = datePicker()
    override fun NodeManager.child3() = datePicker { }

    override fun DatePicker.testDefaultValues() {
        assertNull(value)
    }
}