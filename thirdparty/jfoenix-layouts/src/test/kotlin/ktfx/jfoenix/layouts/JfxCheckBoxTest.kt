package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXCheckBox
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxCheckBoxTest : LayoutsTest<KtfxPane, JFXCheckBox>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXCheckBox = jfxCheckBox { }
    override fun KtfxPane.child2(): JFXCheckBox = jfxCheckBox()
    override fun KtfxPane.child3(): JFXCheckBox = jfxCheckBox { }

    override fun JFXCheckBox.testDefaultValues() {
        assertNull(text)
    }
}
