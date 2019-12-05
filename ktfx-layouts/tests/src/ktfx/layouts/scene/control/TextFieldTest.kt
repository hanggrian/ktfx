package ktfx.layouts.scene.control

import javafx.scene.control.TextField
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.textField
import kotlin.test.assertEquals

class TextFieldTest : LayoutTest<NodeManager, TextField>() {

    override fun createManager() = KtfxPane()
    override fun create() = textField { }
    override fun NodeManager.add() = textField()
    override fun NodeManager.addWithBuilder() = textField { }

    override fun TextField.testDefaultValues() {
        assertEquals("", text)
    }
}