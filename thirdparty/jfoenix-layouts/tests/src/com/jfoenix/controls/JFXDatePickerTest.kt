package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDatePicker
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXDatePickerTest : LayoutsTest<KtfxPane, JFXDatePicker>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxDatePicker { }
    override fun KtfxPane.child2() = jfxDatePicker()
    override fun KtfxPane.child3() = jfxDatePicker { }

    override fun JFXDatePicker.testDefaultValues() {
        assertNull(value)
    }
}
