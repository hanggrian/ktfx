package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.TextField
import kotlin.test.assertEquals

class TextFieldTest : LayoutsStyledTest<KtfxPane, TextField>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = textField {}

    override fun KtfxPane.child2() = textField()

    override fun child3() = styledTextField(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledTextField(styleClass = arrayOf("style"))

    override fun TextField.testDefaultValues() {
        assertEquals("", text)
    }
}
