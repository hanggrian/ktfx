package ktfx.layouts

import javafx.scene.control.ComboBox
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty

class ComboBoxTest : LayoutTest<NodeManager, ComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = comboBox<String> { }
    override fun NodeManager.child2() = comboBox<String>()
    override fun NodeManager.child3() = comboBox<String> { }

    override fun ComboBox<String>.testDefaultValues() {
        assertEmpty(items)
    }
}