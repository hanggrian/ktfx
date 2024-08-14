package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXTextArea
import ktfx.layouts.KtfxPane
import kotlin.test.assertTrue

class JfxTextAreaTest : LayoutsStyledTest<KtfxPane, JFXTextArea>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxTextArea {}

    override fun KtfxPane.child2() = jfxTextArea()

    override fun child3() = styledJfxTextArea(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxTextArea(styleClass = arrayOf("style"))

    override fun JFXTextArea.testDefaultValues() {
        assertTrue(text.isEmpty())
    }
}
