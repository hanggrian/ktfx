package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.TextField
import kotlin.test.assertEquals

class TextFieldTest : LayoutsTest<KtfxPane, TextField>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): TextField = textField { }
    override fun KtfxPane.child2(): TextField = textField()
    override fun KtfxPane.child3(): TextField = textField { }

    override fun TextField.testDefaultValues() {
        assertEquals("", text)
    }
}
