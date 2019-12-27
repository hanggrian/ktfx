package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import org.controlsfx.control.PrefixSelectionComboBox

class PrefixSelectionComboBoxTest : LayoutsTest<NodeManager, PrefixSelectionComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = prefixSelectionComboBox<String> { }
    override fun NodeManager.child2() = prefixSelectionComboBox<String>()
    override fun NodeManager.child3() = prefixSelectionComboBox<String> { }
}