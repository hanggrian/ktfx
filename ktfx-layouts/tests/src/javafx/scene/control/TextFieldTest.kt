package ktfx.layouts

import javafx.scene.control.TextField
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class TextFieldTest : LayoutsTest<KtfxPane, TextField>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = textField { }
    override fun KtfxPane.child2() = textField()
    override fun KtfxPane.child3() = textField { }

    override fun TextField.testDefaultValues() {
        assertEquals("", text)
    }
}