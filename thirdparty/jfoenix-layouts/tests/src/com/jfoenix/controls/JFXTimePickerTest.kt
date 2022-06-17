package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTimePicker
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXTimePickerTest : LayoutsTest<KtfxPane, JFXTimePicker>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxTimePicker { }
    override fun KtfxPane.child2() = jfxTimePicker()
    override fun KtfxPane.child3() = jfxTimePicker { }

    override fun JFXTimePicker.testDefaultValues() {
        assertNull(value)
    }
}
