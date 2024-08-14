package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXTimePicker
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxTimePickerTest : LayoutsStyledTest<KtfxPane, JFXTimePicker>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxTimePicker {}

    override fun KtfxPane.child2() = jfxTimePicker()

    override fun child3() = styledJfxTimePicker(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxTimePicker(styleClass = arrayOf("style"))

    override fun JFXTimePicker.testDefaultValues() {
        assertNull(value)
    }
}
