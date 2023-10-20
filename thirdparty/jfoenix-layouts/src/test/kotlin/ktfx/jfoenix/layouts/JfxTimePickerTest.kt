package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXTimePicker
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxTimePickerTest : LayoutsTest<KtfxPane, JFXTimePicker>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXTimePicker = jfxTimePicker { }

    override fun KtfxPane.child2(): JFXTimePicker = jfxTimePicker()

    override fun KtfxPane.child3(): JFXTimePicker = jfxTimePicker { }

    override fun JFXTimePicker.testDefaultValues() {
        assertNull(value)
    }
}
