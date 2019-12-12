package ktfx.layouts.scene.control

import javafx.scene.control.ComboBox
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.comboBox
import ktfx.test.BaseLayoutTest
import ktfx.test.assertEmpty

class ComboBoxTest : BaseLayoutTest<NodeManager, ComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = comboBox<String> { }
    override fun NodeManager.child2() = comboBox<String>()
    override fun NodeManager.child3() = comboBox<String> { }

    override fun ComboBox<String>.testDefaultValues() {
        assertEmpty(items)
    }
}