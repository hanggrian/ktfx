package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import org.controlsfx.control.CheckListView

class CheckListViewTest : LayoutsTest<NodeManager, CheckListView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = checkListView<String> { }
    override fun NodeManager.child2() = checkListView<String>()
    override fun NodeManager.child3() = checkListView<String> { }

    override fun CheckListView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}