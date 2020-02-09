package ktfx.layouts

import javafx.scene.text.Text
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class TextTest : LayoutsTest<KtfxTextFlow, Text>() {

    override fun manager() = KtfxTextFlow()
    override fun KtfxTextFlow.childCount() = children.size
    override fun child1() = text { }
    override fun KtfxTextFlow.child2() = text()
    override fun KtfxTextFlow.child3() = text { }

    override fun Text.testDefaultValues() {
        assertEquals("", text)
    }
}