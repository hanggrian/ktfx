package ktfx.layouts

import javafx.scene.control.TextArea
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class TextAreaTest : LayoutsTest<KtfxPane, TextArea>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = textArea { }
    override fun KtfxPane.child2() = textArea()
    override fun KtfxPane.child3() = textArea { }

    override fun TextArea.testDefaultValues() {
        assertEquals("", text)
    }
}