package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.DatePicker
import kotlin.test.assertNull

class DatePickerTest : LayoutsTest<KtfxPane, DatePicker>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): DatePicker = datePicker { }

    override fun KtfxPane.child2(): DatePicker = datePicker()

    override fun KtfxPane.child3(): DatePicker = datePicker { }

    override fun DatePicker.testDefaultValues() {
        assertNull(value)
    }
}
