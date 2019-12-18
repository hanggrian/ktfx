package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class ColorPickerTest : BaseLayoutTest<NodeManager, ColorPicker>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = colorPicker { }
    override fun NodeManager.child2() = colorPicker()
    override fun NodeManager.child3() = colorPicker { }

    override fun ColorPicker.testDefaultValues() {
        assertEquals(Color.WHITE, value)
    }
}