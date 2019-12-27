package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.ListView
import ktfx.test.LayoutsTest

class ListViewTest : LayoutsTest<NodeManager, ListView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = listView<String> { }
    override fun NodeManager.child2() = listView<String>()
    override fun NodeManager.child3() = listView<String> { }

    override fun ListView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}