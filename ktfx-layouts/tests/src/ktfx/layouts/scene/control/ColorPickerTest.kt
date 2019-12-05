package ktfx.layouts.scene.control

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.colorPicker
import kotlin.test.assertEquals

class ColorPickerTest : LayoutTest<NodeManager, ColorPicker>(KtfxPane()) {

    override fun create() = colorPicker { }
    override fun NodeManager.add() = colorPicker()
    override fun NodeManager.addWithBuilder() = colorPicker { }

    override fun ColorPicker.testDefaultValues() {
        assertEquals(Color.WHITE, value)
    }
}