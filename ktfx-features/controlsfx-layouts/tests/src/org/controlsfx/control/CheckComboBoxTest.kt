package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest
import ktfx.test.assertEmpty
import org.controlsfx.control.CheckComboBox

class CheckComboBoxTest : BaseLayoutTest<NodeManager, CheckComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = checkComboBox<String> { }
    override fun NodeManager.child2() = checkComboBox<String>()
    override fun NodeManager.child3() = checkComboBox<String> { }

    override fun CheckComboBox<String>.testDefaultValues() {
        assertEmpty(items)
    }
}