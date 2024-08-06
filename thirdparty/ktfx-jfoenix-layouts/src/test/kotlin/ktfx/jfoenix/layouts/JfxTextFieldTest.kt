package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXTextField
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxTextFieldTest : LayoutsTest<KtfxPane, JFXTextField>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXTextField = jfxTextField { }

    override fun KtfxPane.child2(): JFXTextField = jfxTextField()

    override fun KtfxPane.child3(): JFXTextField = jfxTextField { }

    override fun JFXTextField.testDefaultValues() {
        assertNull(text)
    }
}
