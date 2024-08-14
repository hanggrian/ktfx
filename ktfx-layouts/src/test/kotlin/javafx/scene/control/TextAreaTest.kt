package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.TextArea
import kotlin.test.assertEquals

class TextAreaTest : LayoutsStyledTest<KtfxPane, TextArea>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = textArea {}

    override fun KtfxPane.child2() = textArea()

    override fun child3() = styledTextArea(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledTextArea(styleClass = arrayOf("style"))

    override fun TextArea.testDefaultValues() {
        assertEquals("", text)
    }
}
