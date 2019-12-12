package ktfx.layouts.scene.text

import javafx.scene.text.Text
import ktfx.layouts.KtfxTextFlow
import ktfx.layouts.NodeManager
import ktfx.layouts.text
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class TextTest : BaseLayoutTest<NodeManager, Text>() {

    override fun manager() = KtfxTextFlow()
    override fun childCount() = manager.childCount
    override fun child1() = text { }
    override fun NodeManager.child2() = text()
    override fun NodeManager.child3() = text { }

    override fun Text.testDefaultValues() {
        assertEquals("", text)
    }
}