package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import org.controlsfx.control.PrefixSelectionComboBox

class PrefixSelectionComboBoxTest : LayoutTest<NodeManager, PrefixSelectionComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = prefixSelectionComboBox<String> { }
    override fun NodeManager.child2() = prefixSelectionComboBox<String>()
    override fun NodeManager.child3() = prefixSelectionComboBox<String> { }
}