package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXDatePicker
import ktfx.layouts.KtfxPane
import kotlin.test.Ignore
import kotlin.test.assertNull

@Ignore
class JfxDatePickerTest : LayoutsStyledTest<KtfxPane, JFXDatePicker>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxDatePicker {}

    override fun KtfxPane.child2() = jfxDatePicker()

    override fun child3() = styledJfxDatePicker(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxDatePicker(styleClass = arrayOf("style"))

    override fun JFXDatePicker.testDefaultValues() {
        assertNull(value)
    }
}
