package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty
import org.controlsfx.control.CheckComboBox
import org.controlsfx.control.CheckListView

class CheckListViewTest : LayoutTest<NodeManager, CheckListView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = checkListView<String> { }
    override fun NodeManager.child2() = checkListView<String>()
    override fun NodeManager.child3() = checkListView<String> { }

    override fun CheckListView<String>.testDefaultValues() {
        assertEmpty(items)
    }
}