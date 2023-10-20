package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXDatePicker
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxDatePickerTest : LayoutsTest<KtfxPane, JFXDatePicker>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXDatePicker = jfxDatePicker { }

    override fun KtfxPane.child2(): JFXDatePicker = jfxDatePicker()

    override fun KtfxPane.child3(): JFXDatePicker = jfxDatePicker { }

    override fun JFXDatePicker.testDefaultValues() {
        assertNull(value)
    }
}
