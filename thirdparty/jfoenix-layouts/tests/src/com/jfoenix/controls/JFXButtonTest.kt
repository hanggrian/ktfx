package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXButton
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXButtonTest : LayoutsTest<KtfxPane, JFXButton>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxButton { }
    override fun KtfxPane.child2() = jfxButton()
    override fun KtfxPane.child3() = jfxButton { }

    override fun JFXButton.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
