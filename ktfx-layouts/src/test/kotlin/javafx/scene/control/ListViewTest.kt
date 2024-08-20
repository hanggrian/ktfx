package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ListView

class ListViewTest : LayoutsStyledTest<KtfxPane, ListView<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = listView<String> {}

    override fun KtfxPane.child2() = listView<String>()

    override fun child3() = styledListView<String>()

    override fun KtfxPane.child4() = styledListView<String>()

    override fun ListView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
