package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.TextArea
import kotlin.test.assertEquals

class TextAreaTest : LayoutsTest<KtfxPane, TextArea>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): TextArea = textArea { }

    override fun KtfxPane.child2(): TextArea = textArea()

    override fun KtfxPane.child3(): TextArea = textArea { }

    override fun TextArea.testDefaultValues() {
        assertEquals("", text)
    }
}
