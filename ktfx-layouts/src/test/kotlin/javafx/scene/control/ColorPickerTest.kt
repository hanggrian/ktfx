package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import kotlin.test.assertEquals

class ColorPickerTest : LayoutsTest<KtfxPane, ColorPicker>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): ColorPicker = colorPicker { }
    override fun KtfxPane.child2(): ColorPicker = colorPicker()
    override fun KtfxPane.child3(): ColorPicker = colorPicker { }

    override fun ColorPicker.testDefaultValues() {
        assertEquals(Color.WHITE, value)
    }
}
