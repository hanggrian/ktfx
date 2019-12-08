package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty
import org.controlsfx.control.CheckComboBox
import org.controlsfx.control.CheckListView
import org.controlsfx.control.CheckTreeView
import kotlin.test.assertNull

class CheckTreeViewTest : LayoutTest<NodeManager, CheckTreeView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = checkTreeView<String> { }
    override fun NodeManager.child2() = checkTreeView<String>()
    override fun NodeManager.child3() = checkTreeView<String> { }

    override fun CheckTreeView<String>.testDefaultValues() {
        assertNull(root)
    }
}