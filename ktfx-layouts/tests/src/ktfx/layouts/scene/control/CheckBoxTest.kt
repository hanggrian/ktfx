package ktfx.layouts.scene.control

import javafx.scene.control.CheckBox
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.checkBox
import kotlin.test.assertNull

class CheckBoxTest : LayoutTest<NodeManager, CheckBox>(KtfxPane()) {

    override fun create() = checkBox { }
    override fun NodeManager.add() = checkBox()
    override fun NodeManager.addWithBuilder() = checkBox { }

    override fun CheckBox.testDefaultValues() {
        assertNull(text)
    }
}