package ktfx.layouts.scene.control

import javafx.scene.control.TextArea
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.textArea
import kotlin.test.assertEquals

class TextAreaTest : LayoutTest<NodeManager, TextArea>() {

    override fun createManager() = KtfxPane()
    override fun create() = textArea { }
    override fun NodeManager.add() = textArea()
    override fun NodeManager.addWithBuilder() = textArea { }

    override fun TextArea.testDefaultValues() {
        assertEquals("", text)
    }
}