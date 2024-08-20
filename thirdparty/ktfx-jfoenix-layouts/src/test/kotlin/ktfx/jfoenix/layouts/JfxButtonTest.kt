package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXButton
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxButtonTest : LayoutsStyledTest<KtfxPane, JFXButton>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxButton {}

    override fun KtfxPane.child2() = jfxButton()

    override fun child3() = styledJfxButton()

    override fun KtfxPane.child4() = styledJfxButton()

    override fun JFXButton.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
