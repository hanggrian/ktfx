package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXCheckBox
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXCheckBoxTest : LayoutsTest<KtfxPane, JFXCheckBox>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxCheckBox { }
    override fun KtfxPane.child2() = jfxCheckBox()
    override fun KtfxPane.child3() = jfxCheckBox { }

    override fun JFXCheckBox.testDefaultValues() {
        assertNull(text)
    }
}
