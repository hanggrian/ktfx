package ktfx.layouts.scene.control

import javafx.scene.control.RadioButton
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.radioButton
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class RadioButtonTest : BaseLayoutTest<NodeManager, RadioButton>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = radioButton { }
    override fun NodeManager.child2() = radioButton()
    override fun NodeManager.child3() = radioButton { }

    override fun RadioButton.testDefaultValues() {
        assertNull(text)
    }
}