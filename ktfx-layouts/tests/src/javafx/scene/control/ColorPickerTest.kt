package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class ColorPickerTest : LayoutsTest<KtfxPane, ColorPicker>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = colorPicker { }
    override fun KtfxPane.child2() = colorPicker()
    override fun KtfxPane.child3() = colorPicker { }

    override fun ColorPicker.testDefaultValues() {
        assertEquals(Color.WHITE, value)
    }
}
