package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextArea
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXTextAreaTest : LayoutsTest<KtfxPane, JFXTextArea>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxTextArea { }
    override fun KtfxPane.child2() = jfxTextArea()
    override fun KtfxPane.child3() = jfxTextArea { }

    override fun JFXTextArea.testDefaultValues() {
        assertNull(text)
    }
}