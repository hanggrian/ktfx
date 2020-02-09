package ktfx.layouts

import javafx.scene.control.RadioButton
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class RadioButtonTest : LayoutsTest<KtfxPane, RadioButton>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = radioButton { }
    override fun KtfxPane.child2() = radioButton()
    override fun KtfxPane.child3() = radioButton { }

    override fun RadioButton.testDefaultValues() {
        assertNull(text)
    }
}