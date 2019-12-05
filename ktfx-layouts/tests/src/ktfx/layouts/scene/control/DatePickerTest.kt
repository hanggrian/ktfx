package ktfx.layouts.scene.control

import javafx.scene.control.DatePicker
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.datePicker
import kotlin.test.assertNull

class DatePickerTest : LayoutTest<NodeManager, DatePicker>(KtfxPane()) {

    override fun create() = datePicker { }
    override fun NodeManager.add() = datePicker()
    override fun NodeManager.addWithBuilder() = datePicker { }

    override fun DatePicker.testDefaultValues() {
        assertNull(value)
    }
}