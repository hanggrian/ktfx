package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty
import org.controlsfx.control.CheckComboBox
import org.controlsfx.control.CheckListView
import org.controlsfx.control.GridView

class GridViewTest : LayoutTest<NodeManager, GridView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = gridView<String> { }
    override fun NodeManager.child2() = gridView<String>()
    override fun NodeManager.child3() = gridView<String> { }

    override fun GridView<String>.testDefaultValues() {
        assertEmpty(items)
    }
}