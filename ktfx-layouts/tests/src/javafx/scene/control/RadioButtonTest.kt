package ktfx.layouts

import javafx.scene.control.RadioButton
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class RadioButtonTest : LayoutsTest<NodeManager, RadioButton>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = radioButton { }
    override fun NodeManager.child2() = radioButton()
    override fun NodeManager.child3() = radioButton { }

    override fun RadioButton.testDefaultValues() {
        assertNull(text)
    }
}