package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextField
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXTextFieldTest : LayoutsTest<KtfxPane, JFXTextField>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxTextField { }
    override fun KtfxPane.child2() = jfxTextField()
    override fun KtfxPane.child3() = jfxTextField { }

    override fun JFXTextField.testDefaultValues() {
        assertNull(text)
    }
}