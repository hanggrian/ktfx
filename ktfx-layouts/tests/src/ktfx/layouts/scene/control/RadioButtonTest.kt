package ktfx.layouts.scene.control

import javafx.scene.control.RadioButton
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.radioButton
import kotlin.test.assertNull

class RadioButtonTest : LayoutTest<NodeManager, RadioButton>(KtfxPane()) {

    override fun create() = radioButton { }
    override fun NodeManager.add() = radioButton()
    override fun NodeManager.addWithBuilder() = radioButton { }

    override fun RadioButton.testDefaultValues() {
        assertNull(text)
    }
}