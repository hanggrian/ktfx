package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXCheckBox
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxCheckBoxTest : LayoutsStyledTest<KtfxPane, JFXCheckBox>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxCheckBox {}

    override fun KtfxPane.child2() = jfxCheckBox()

    override fun child3() = styledJfxCheckBox()

    override fun KtfxPane.child4() = styledJfxCheckBox()

    override fun JFXCheckBox.testDefaultValues() {
        assertNull(text)
    }
}
