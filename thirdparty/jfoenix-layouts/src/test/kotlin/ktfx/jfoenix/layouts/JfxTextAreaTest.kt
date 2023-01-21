package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXTextArea
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxTextAreaTest : LayoutsTest<KtfxPane, JFXTextArea>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXTextArea = jfxTextArea { }
    override fun KtfxPane.child2(): JFXTextArea = jfxTextArea()
    override fun KtfxPane.child3(): JFXTextArea = jfxTextArea { }

    override fun JFXTextArea.testDefaultValues() {
        assertNull(text)
    }
}
