package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXColorPicker
import javafx.scene.paint.Color
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxColorPickerTest : LayoutsStyledTest<KtfxPane, JFXColorPicker>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxColorPicker {}

    override fun KtfxPane.child2() = jfxColorPicker()

    override fun child3() = styledJfxColorPicker(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxColorPicker(styleClass = arrayOf("style"))

    override fun JFXColorPicker.testDefaultValues() {
        assertEquals(Color.WHITE, value)
    }
}
