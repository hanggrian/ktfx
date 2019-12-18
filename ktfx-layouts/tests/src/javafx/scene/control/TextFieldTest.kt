package ktfx.layouts

import javafx.scene.control.TextField
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class TextFieldTest : BaseLayoutTest<NodeManager, TextField>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = textField { }
    override fun NodeManager.child2() = textField()
    override fun NodeManager.child3() = textField { }

    override fun TextField.testDefaultValues() {
        assertEquals("", text)
    }
}