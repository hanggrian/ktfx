package ktfx.layouts.scene.control

import javafx.scene.control.ComboBox
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.comboBox
import ktfx.test.assertEmpty

class ComboBoxTest : LayoutTest<NodeManager, ComboBox<String>>() {

    override fun createManager() = KtfxPane()
    override fun create() = comboBox<String> { }
    override fun NodeManager.add() = comboBox<String>()
    override fun NodeManager.addWithBuilder() = comboBox<String> { }

    override fun ComboBox<String>.testDefaultValues() {
        assertEmpty(items)
    }
}