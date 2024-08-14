package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.DatePicker
import kotlin.test.assertNull

class DatePickerTest : LayoutsStyledTest<KtfxPane, DatePicker>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = datePicker {}

    override fun KtfxPane.child2() = datePicker()

    override fun child3() = styledDatePicker(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledDatePicker(styleClass = arrayOf("style"))

    override fun DatePicker.testDefaultValues() {
        assertNull(value)
    }
}
