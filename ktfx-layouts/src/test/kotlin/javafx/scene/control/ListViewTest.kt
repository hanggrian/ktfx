package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.ListView

class ListViewTest : LayoutsTest<KtfxPane, ListView<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): ListView<String> = listView { }

    override fun KtfxPane.child2(): ListView<String> = listView()

    override fun KtfxPane.child3(): ListView<String> = listView { }

    override fun ListView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
