package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXTextField
import ktfx.layouts.KtfxPane
import kotlin.test.assertTrue

class JfxTextFieldTest : LayoutsStyledTest<KtfxPane, JFXTextField>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxTextField {}

    override fun KtfxPane.child2() = jfxTextField()

    override fun child3() = styledJfxTextField()

    override fun KtfxPane.child4() = styledJfxTextField()

    override fun JFXTextField.testDefaultValues() {
        assertTrue(text.isEmpty())
    }
}
