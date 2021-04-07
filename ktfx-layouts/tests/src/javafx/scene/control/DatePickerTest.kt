package ktfx.layouts

import javafx.scene.control.DatePicker
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class DatePickerTest : LayoutsTest<KtfxPane, DatePicker>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = datePicker { }
    override fun KtfxPane.child2() = datePicker()
    override fun KtfxPane.child3() = datePicker { }

    override fun DatePicker.testDefaultValues() {
        assertNull(value)
    }
}