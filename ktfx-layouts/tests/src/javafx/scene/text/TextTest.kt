package ktfx.layouts

import javafx.scene.text.Text
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class TextTest : LayoutsTest<NodeManager, Text>() {

    override fun manager() = KtfxTextFlow()
    override fun childCount() = manager.childCount
    override fun child1() = text { }
    override fun NodeManager.child2() = text()
    override fun NodeManager.child3() = text { }

    override fun Text.testDefaultValues() {
        assertEquals("", text)
    }
}