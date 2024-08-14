package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import kotlin.test.assertEquals

class ColorPickerTest : LayoutsStyledTest<KtfxPane, ColorPicker>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = colorPicker {}

    override fun KtfxPane.child2() = colorPicker()

    override fun child3() = styledColorPicker(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledColorPicker(styleClass = arrayOf("style"))

    override fun ColorPicker.testDefaultValues() {
        assertEquals(Color.WHITE, value)
    }
}
