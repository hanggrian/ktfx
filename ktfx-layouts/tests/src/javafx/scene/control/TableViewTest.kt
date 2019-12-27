package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.TableView
import ktfx.test.LayoutsTest

class TableViewTest : LayoutsTest<NodeManager, TableView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = tableView<String> { }
    override fun NodeManager.child2() = tableView<String>()
    override fun NodeManager.child3() = tableView<String> { }

    override fun TableView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}