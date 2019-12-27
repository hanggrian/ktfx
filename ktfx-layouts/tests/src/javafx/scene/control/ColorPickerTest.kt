package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class ColorPickerTest : LayoutsTest<NodeManager, ColorPicker>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = colorPicker { }
    override fun NodeManager.child2() = colorPicker()
    override fun NodeManager.child3() = colorPicker { }

    override fun ColorPicker.testDefaultValues() {
        assertEquals(Color.WHITE, value)
    }
}