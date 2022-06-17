package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRadioButton
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXRadioButtonTest : LayoutsTest<KtfxPane, JFXRadioButton>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxRadioButton { }
    override fun KtfxPane.child2() = jfxRadioButton()
    override fun KtfxPane.child3() = jfxRadioButton { }

    override fun JFXRadioButton.testDefaultValues() {
        assertNull(text)
    }
}
